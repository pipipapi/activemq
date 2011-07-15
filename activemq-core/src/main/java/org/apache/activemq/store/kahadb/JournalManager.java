/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.store.kahadb;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.kahadb.journal.DataFile;
import org.apache.kahadb.journal.Journal;

public interface JournalManager {

    void start() throws IOException;

    void close() throws IOException;

    Journal getJournal(ActiveMQDestination destination) throws IOException;

    void setDirectory(File directory);

    void setMaxFileLength(int maxFileLength);

    void setCheckForCorruptionOnStartup(boolean checkForCorruptJournalFiles);

    void setChecksum(boolean checksum);

    void setWriteBatchSize(int batchSize);

    void setArchiveDataLogs(boolean archiveDataLogs);

    void setStoreSize(AtomicLong storeSize);

    void setDirectoryArchive(File directoryArchive);

    void delete() throws IOException;

    Map<Integer, DataFile> getFileMap();

    Collection<Journal> getJournals();

    Collection<Journal> getJournals(Set<ActiveMQDestination> set);
}
