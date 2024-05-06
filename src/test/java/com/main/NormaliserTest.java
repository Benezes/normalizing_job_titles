package com.main;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormaliserTest {
    
    @Test
    public void shouldNormaliseJavaEngineer() {
        Normaliser n = new Normaliser();

        String normalisedTitle = n.normalise("Java Engineer");

        assertNotNull(normalisedTitle);
        assertEquals("Software Engineer", normalisedTitle);
    }

    @Test
    public void shouldNormaliseArchitect() {
        Normaliser n = new Normaliser();

        String normalisedTitle = n.normalise("Solution Architect");

        assertNotNull(normalisedTitle);
        assertEquals("Architect", normalisedTitle);
    }

    @Test
    public void shouldNormaliseIllegalArgumentExceptionInNormaliseNull() {
        Normaliser n = new Normaliser();

        assertThrows(IllegalArgumentException.class, () -> {
            n.normalise(null);
        });
    }

    @Test
    public void shouldNormaliseIllegalArgumentExceptionInAddNormalizedJobTitleNull() {
        Normaliser n = new Normaliser();
        assertThrows(IllegalArgumentException.class, () -> {
            n.normalise("Spine Surgeon");
            n.addNormalizedJobTitle(null);
        });
    }

    @Test
    public void shouldNormaliseIllegalArgumentExceptionInNormaliseEmpty() {
        Normaliser n = new Normaliser();

        assertThrows(IllegalArgumentException.class, () -> {
            n.normalise(StringUtils.EMPTY);
        });
    }

    @Test
    public void shouldNormaliseIllegalArgumentExceptionInAddNormalizedJobTitleEmpty() {
        Normaliser n = new Normaliser();
        assertThrows(IllegalArgumentException.class, () -> {
            n.normalise("Spine Surgeon");
            n.addNormalizedJobTitle(StringUtils.EMPTY);
        });
    }

    @Test
    public void shouldAddJobTitleAndNormaliseSpineSurgeon() {
        Normaliser n = new Normaliser();
        n.addNormalizedJobTitle("Surgeon");
        String normalisedTitle = n.normalise("Spine Surgeon");

        assertEquals("Surgeon", normalisedTitle);
    }
}