public class Person implements Comparable<Person> {

    /***** TODO: (Part 2) create helper inner class for Identity*****/

    // CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Jamie Doe";
    public static final int DEFAULT_PRIVILEGE = 100;

    // INSTANCE VARIABLES
    private String name;
    private Identity story;
    private int privilege;

    // CONSTRUCTORS
    public Person(String name, Identity story, int privilege) {
        this.setAll(name, story, privilege);
    }

    public Person() {
        this(DEFAULT_NAME, new Identity("Unknown", "Unknown"), DEFAULT_PRIVILEGE); // Default Identity
    }

    public Person(Person original) {
        if (original == null) {
            throw new IllegalArgumentException("Cannot copy null object in Person copy constructor");
        } else {
            this.setAll(original.name, original.story, original.privilege);
        }
    }

    // MUTATORS/SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setStory(Identity story) {
        this.story = story;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public void setAll(String name, Identity story, int privilege) {
        this.setPrivilege(privilege);
        this.setName(name);
        this.setStory(story);
    }

    // ACCESSORS / GETTERS
    public String getName() {
        return this.name;
    }

    public Identity getStory() {
        return this.story;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    // OTHER REQUIRED METHODS
    @Override
    public String toString() {
        return "My name is " + this.name + " and my identity is " + this.story + "\n" +
               "According to this calculator I ended up with " + this.privilege + " estimated privilege points";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || (!(other instanceof Person))) {
            return false;
        }

        Person otherPerson = (Person) other;
        return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
               this.privilege == otherPerson.privilege;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.privilege, other.privilege);
    }

    // INNER CLASS: Identity
    public static class Identity {
        private String pronouns;
        private String background;

        // Constructor for Identity
        public Identity(String pronouns, String background) {
            this.pronouns = pronouns;
            this.background = background;
        }

        // Getters and setters for Identity fields
        public String getPronouns() {
            return pronouns;
        }

        public void setPronouns(String pronouns) {
            this.pronouns = pronouns;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        @Override
        public String toString() {
            return "Pronouns: " + this.pronouns + ", Background: " + this.background;
        }
    }
}
