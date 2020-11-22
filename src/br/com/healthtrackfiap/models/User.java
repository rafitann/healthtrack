package br.com.healthtrackfiap.models;

import java.io.Serializable;

public class User  extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userID;
    private String password;


    public User() {

    }

    /**
     * @param userID   User do Usuário.
     * @param password Senha do Usuário
     * @return Método que atua como Cadastro do usuário no Health Track
     */

    public String register(String userID, String password) {

        userID = super.getEmail();
        this.password = password;

        return "Usuário registrado com sucesso";

    }

    /**
     * @return UserId retorna o userId (Email)
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID Email do usário.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @param password Método que muda senha do Usuário
     */
    public void changePassword(String password) {
        this.password = password;
    }

    /**
     * @return Pega senha do usuário. Get Privado
     */
    @SuppressWarnings("unused")
    private String getPassword() {
        return password;
    }

	
	
}