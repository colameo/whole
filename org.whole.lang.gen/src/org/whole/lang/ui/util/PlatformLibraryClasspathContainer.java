/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.ui.util;

import static org.whole.lang.ui.util.PlatformLibraryContainerInitializer.calculatePath;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

/**
 * @author Enrico Persiani
 */
public class PlatformLibraryClasspathContainer implements IClasspathContainer {
	public static final String WHOLERT_CONTAINER = "org.whole.lang.ide.WHOLERT_CONTAINER";

	public static final Set<String> BUNDLE_IDS;
	static {
		Set<String> bundles = new HashSet<String>();
		bundles.add("org.whole.lang");
		bundles.add("org.whole.langs.core");
		bundles.add("org.whole.langs.core.op");
		bundles.add("org.whole.langs.legacy");
		bundles.add("org.whole.langs.legacy.op");
		bundles.add("org.whole.langs.db");
		bundles.add("org.whole.langs.db.op");
		
		// enabling features
		bundles.add("com.fasterxml.jackson");
		bundles.add("net.sourceforge.jodatime");
		bundles.add("org.objectweb.asm");
		bundles.add("org.beanshell.bsh");
		bundles.add("org.h2");
		bundles.add("org.mozilla.rhino");

		BUNDLE_IDS = Collections.unmodifiableSet(bundles);
	};

	protected Set<String> excludedBundleIDs;

	public PlatformLibraryClasspathContainer() {
		this(Collections.<String>emptySet());
	}
	public PlatformLibraryClasspathContainer(Set<String> excludedBundleIDs) {
		setExcludedBundleIDs(excludedBundleIDs);
	}

	public Set<String> getExcludedBundleIDs() {
		return excludedBundleIDs;
	}
	public void setExcludedBundleIDs(Set<String> exludefBundleIDs) {
		this.excludedBundleIDs = exludefBundleIDs;
	}

	protected void addBundle(String bundleId, List<IClasspathEntry> classpathEntryList) {
		try {
			Bundle bundle = Platform.getBundle(bundleId);
			String classPath = bundle.getHeaders().get("Bundle-ClassPath");
			File bundleFile = FileLocator.getBundleFile(bundle);
			if (classPath == null) {
				Path bundlePath = new Path(bundleFile.getAbsolutePath());
				classpathEntryList.add(JavaCore.newLibraryEntry(bundlePath, null, null));
			} else if (".".equals(classPath)){
				String suffix = bundleFile.isDirectory() ? "/bin" : "";
				Path bundlePath = new Path(bundleFile.getAbsolutePath() + suffix);
				classpathEntryList.add(JavaCore.newLibraryEntry(bundlePath, null, null));
			} else {
				Path bundlePath = new Path(bundleFile.getAbsolutePath()+"/"+classPath);
				classpathEntryList.add(JavaCore.newLibraryEntry(bundlePath, null, null));
			}
		} catch (Exception e) {
		}
	}
	protected List<IClasspathEntry> calculateClasspathEntries() {
		List<IClasspathEntry> classpathEntryList = new ArrayList<IClasspathEntry>(BUNDLE_IDS.size() - excludedBundleIDs.size());
		for (String bundleId : BUNDLE_IDS)
			if (!excludedBundleIDs.contains(bundleId))
				addBundle(bundleId, classpathEntryList);
		return classpathEntryList;
	}

	private IClasspathEntry[] classpathEntries;

	public IClasspathEntry[] getClasspathEntries() {
		if (classpathEntries == null)
			classpathEntries = calculateClasspathEntries().toArray(new IClasspathEntry[0]);
		return classpathEntries;
	}

	public String getDescription() {
		return "Whole Platform Library";
	}

	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	public IPath getPath() {
		return calculatePath(excludedBundleIDs);
	}

	private static final IPath BASE_PATH =  new Path(WHOLERT_CONTAINER);
	public static IPath getBasePath() {
		return BASE_PATH;
	}
	public static boolean sameKind(IClasspathEntry entry) {
		return sameKind(entry.getPath());
	}
	public static boolean sameKind(IPath entry) {
		return entry.segmentCount() > 0 && WHOLERT_CONTAINER.equals(entry.segment(0));
	}
}