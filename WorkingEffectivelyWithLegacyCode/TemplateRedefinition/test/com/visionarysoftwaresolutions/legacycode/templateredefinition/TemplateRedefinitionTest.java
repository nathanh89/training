package com.visionarysoftwaresolutions.legacycode.templateredefinition;

import com.visionarysoftwaresolutions.legacycode.templateredefinition.original.Animal;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TemplateRedefinitionTest {
    @Test
     public void testOriginalProblem() {
        Animal wolf = new Animal();
        wolf.roar();
        assertTrue(wolf.isTired());
     }
}
