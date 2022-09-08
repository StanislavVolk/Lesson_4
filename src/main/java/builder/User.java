package builder;

public class User {
    private final String name;
    private final String surname;
    private final String addres;
    private final String emale;

    private User(Builder builder){
        name = builder.name;
        surname = builder.surname;
        addres = builder.addres;
        emale = builder.emale;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddres() {
        return addres;
    }

    public String getEmale() {
        return emale;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder{
        private String name;
        private String surname;
        private  String addres;
        private String emale;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAddres(String addres) {
            this.addres = addres;
            return this;
        }

        public Builder setEmale(String emale) {
            this.emale = emale;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
