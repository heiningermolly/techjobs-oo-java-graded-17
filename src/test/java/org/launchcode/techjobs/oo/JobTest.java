package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId(),  .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().toString(), "ACME");
        assertEquals(job1.getLocation().toString(), "Desert");
        assertEquals(job1.getPositionType().toString(), "Quality control");
        assertEquals(job1.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        Job job2 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        String str = (job1.toString());
//        String str = System.lineSeparator() + "hello" + System.lineSeparator();
//        System.out.println(str.substring(1, 2));
//        System.out.println(str.indexOf(lineSeparator()));
//        System.out.println(str.substring(str.length()-1, str.length()).equals(lineSeparator()));

        assertEquals(str.substring(0, 1), lineSeparator());
        assertEquals(str.substring(str.length()-1, str.length()), lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        String str = (job1.toString());
        assertTrue(str.contains("ID: "));
        assertTrue(str.contains("Name: "));
        assertTrue(str.contains("Employer: "));
        assertTrue(str.contains("Location: "));
        assertTrue(str.contains("Position Type: "));
        assertTrue(str.contains("Core Competency: "));
        assertTrue(str.contains(String.valueOf(job1.getId())));
        assertTrue(str.contains(job1.getName()));
        assertTrue(str.contains(job1.getEmployer().toString()));
        assertTrue(str.contains(job1.getLocation().toString()));
        assertTrue(str.contains(job1.getPositionType().toString()));
        assertTrue(str.contains(job1.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job();
        Job job2 = new Job(null, new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        Job job3 = new Job("Goblin queen", null, new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        Job job4 = new Job("Goblin queen", new Employer("Goblin Tribe"), null, new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        Job job5 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), null, new CoreCompetency("Cruelty"));
        Job job6 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), null);
        Job job7 = new Job("Goblin queen", new Employer("Goblin Tribe"), new Location("Enchanted Forest"), new PositionType("Monarch"), new CoreCompetency("Cruelty"));
        assertTrue(job1.toString().contains("Data not available"));
        assertTrue(job2.toString().contains("Data not available"));
        assertTrue(job3.toString().contains("Data not available"));
        assertTrue(job4.toString().contains("Data not available"));
        assertTrue(job5.toString().contains("Data not available"));
        assertTrue(job6.toString().contains("Data not available"));
        assertFalse(job7.toString().contains("Data not available"));
    }

}
