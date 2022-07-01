package com.revature.repository;

import java.util.List;

public interface DAO<G> {

    G create(G g);

    List<G> getAll();

}
