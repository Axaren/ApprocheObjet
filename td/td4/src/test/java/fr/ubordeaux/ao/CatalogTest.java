package fr.ubordeaux.ao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {
  private Catalog testCatalog;
  private final Reference testRef = new Reference(
      "testId",
      "testName",
      "testDesc",
      new Price(50));

  private Set<Reference> generateReferences(int number) {
    HashSet<Reference> references = new HashSet<>(number);
    Random random = new Random();
    for (int i = 0; i < number; i++) {
      references.add(new Reference("test" + i,"test" + i,"test", new Price(random.nextInt())));
    }
    return references;
  }


  @BeforeEach
  void setUp() {
    testCatalog = new CatalogImpl("test");
  }

  @AfterEach
  void tearDown() {
    testCatalog = null;
  }

  @Test
  void nameLengthRequirement() {
    assertThrows(IllegalArgumentException.class,() -> new CatalogImpl("a")); // too short
    assertThrows(IllegalArgumentException.class, () -> new CatalogImpl("aaaaaaaaaaa")); // too long
    assertDoesNotThrow(() -> new CatalogImpl("aaaaa")); // correct
  }

  @Test
  void findReferenceById() {
  }

  @Test
  void addReference() {
  }

  @Test
  void removeReference() {
  }

  @Test
  void getOwnReferences() {
    assertTrue(testCatalog.getOwnReferences().isEmpty());
    testCatalog.addReference(testRef);
    assertTrue(testCatalog.getOwnReferences().contains(testRef));
    assertEquals(testRef, testCatalog.getOwnReferences().iterator().next());

    testCatalog.addCatalog(new CatalogImpl("otherTestCatalog", generateReferences(50)));
    assertEquals(1,testCatalog.getOwnReferences().size());

  }

  @Test
  void getAllReferences() {
  }

  @Test
  void addCatalog() {
  }

  @Test
  void removeCatalog() {
  }
}