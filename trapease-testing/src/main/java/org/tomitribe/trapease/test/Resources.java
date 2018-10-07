/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.tomitribe.trapease.test;

import org.tomitribe.util.Files;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Keep this one simple and representing the structure of the test setup
 * Put any actual asserts or real logic somewhere else.
 */
public class Resources {

    private final File base;
    private final File actual;
    private final File tempSource;
    private final File expected;
    private final File input;

    public Resources(final String name) {
        final URL resource = Resources.class.getClassLoader().getResource("root.txt");
        assertNotNull(resource);
        final File file = Urls.toFile(resource);
        assertNotNull(file);
        this.base = new File(file.getParentFile(), name);
        this.actual = tmpdir();
        this.tempSource = tmpdir();
        this.expected = new File(base, "expected");
        this.input = new File(base, "input");
    }

    public static Resources name(final String name) {
        return new Resources(name);
    }

    private Map<String, File> map(final File dir, final String regex) throws IOException {
        final Map<String, File> map = new LinkedHashMap<>();

        final List<File> files = Files.collect(dir, regex);
        for (final File file : files) {
            final String relativePath = file.getAbsolutePath().substring(dir.getAbsolutePath().length() + 1);
            map.put(relativePath, file);
        }
        return map;
    }

    public File expected() {
        return expected;
    }

    public File tempSource() {
        return tempSource;
    }

    public Map<String, File> expected(final String regex) throws IOException {
        return map(expected(), regex);
    }

    public File actual() {
        return actual;
    }

    public Map<String, File> actual(final String regex) throws IOException {
        return map(actual(), regex);
    }

    public File input() {
        return input;
    }

    public static File tmpdir() {
        final File file = Files.tmpdir();
        new CleanOnExit().clean(file);
        return file;
    }
}