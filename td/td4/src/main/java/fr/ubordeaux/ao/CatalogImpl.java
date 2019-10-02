package fr.ubordeaux.ao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogImpl implements Catalog {

  private Set<Reference> references;
  private Map<String, Catalog> catalogs;
  private String name;

  public CatalogImpl(String name) {
    this();
      if (!name.matches("[a-z]{3,12}")) {
          throw new IllegalArgumentException(
              "Catalog name has to be all lowercase"
                  + " and between 3 and 12 characters long");
      }
    this.name = name;
  }

  public CatalogImpl(String name, Set<Reference> refs) {
    this(name);
    this.references = refs;
  }

  public CatalogImpl() {
    name = UUID.randomUUID().toString()
        .substring(24).toLowerCase();
    references = new HashSet<>();
    catalogs = new HashMap<>();
  }

  public int size() {
    return getAllReferences().size();
  }

  @Override
  public String getName() {
    return name;
  }

  public Reference findReferenceById(String id) {
    return getAllReferences()
        .stream()
        .filter(reference -> reference.getId().equals(id))
        .findFirst()
        .orElseThrow(
            () -> new ReferenceManagementException(
                "cannot find Reference, id unknown !"));
  }

  public void addReference(Reference reference) {
    references.add(reference);
  }

  public void removeReference(Reference reference) {
    references.remove(reference);
  }

  @Override
  public Set<Reference> getOwnReferences() {
    return references;
  }

  @Override
  public Set<Reference> getAllReferences() {
    return Stream.concat(getOwnReferences().stream(),
        catalogs
            .values()
            .stream()
            .flatMap(c -> c.getAllReferences().stream()))
        .collect(Collectors.toSet());
  }

  @Override
  public void addCatalog(Catalog catalog) {
      if (catalogs.containsKey(catalog.getName())) {
          throw new IllegalArgumentException(
              "A catalog with that name already exists");
      }
    catalogs.put(catalog.getName(), catalog);
  }

  @Override
  public void removeCatalog(String name) {
    catalogs.remove(name);
  }
}
