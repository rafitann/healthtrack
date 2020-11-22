package br.com.healthtrackfiap.models;

public class Person {
    private String name;
    private byte age;
    private String email;
    private int cpf;
    private int phone;
    private double weight;
    private double heigth;


    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    /**
     * @return Nome do Usuário
     */

    public String getName() {
        return name;
    }

    /**
     * @param name Nome do Usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Idade do Usuário
     */
    public byte getAge() {
        return age;
    }

    /**
     * @param age Idade do Usuário
     */
    public void setAge(byte age) {
        this.age = age;
    }

    /**
     * @return Email do Usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Email do Usuário
     *
     * @param email Email do Usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return CPF do Usuário
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf CPF do Usuário
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    /**
     * @return Celular ou Telefone do Usuário
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone Telefone ou celular do Usuário
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return Peso do Usuário
     */

    public double getWeight() {
        return weight;
    }

    /**
     * @param weight Peso do Usuário
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return Altura do Usuário
     */

    public double getHeigth() {
        return heigth;
    }

    /**
     * @param heigth Altura do Usuário
     */

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

}
