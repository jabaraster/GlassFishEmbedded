/**
 * 
 */
package info.jabara.sandbox.service;

import info.jabara.sandbox.entity.EEmployee;

import java.util.List;

/**
 * @author jabaraster
 */
public interface HogeService {

    /**
     * @return -
     */
    List<EEmployee> getAll();

    /**
     * 
     */
    void insert();

    /**
     * @return -
     */
    String getNow();
}
