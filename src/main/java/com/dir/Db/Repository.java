package com.dir.Db;

import java.util.List;
import java.util.Map;

public interface Repository {
    boolean addInformation(Map<?,?> catalog);
    boolean createRepository();
    List<?> findInformation();
    List<?> findInformation(Map<?,?> conditions);
    boolean removeInformation(Map<?,?> conditions);
    boolean updateInformation(Map<?,?> conditions);
}
