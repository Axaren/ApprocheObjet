package fr.ubordeaux.ao;

import java.util.Set;

public interface Catalog {
    int size();
    String getName();
    Reference findReferenceById(String id);
    void addReference(Reference reference);
    void removeReference(Reference reference);
    Set<Reference> getOwnReferences();
    Set<Reference> getAllReferences();
    void addCatalog(Catalog catalog);
    void removeCatalog(String name);

}
