/**
*#Universidade Federal de Pelotas#
*#Unidade: CDTEC
*#Curso: Ciência da Computação
*#Disciplina: Programação Orientada a Objetos
*#Profº: Felipe de Souza Marques
*#Aluno: Maicon de Menezes
*#Projeto: 
*#Módulo: 

*@author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
*@date   19/02/2018
*/
package addressbookmefx.data;

import java.io.Serializable;

/**
 *
 * @author MaJoy
 */
public class Contact extends Person implements Serializable {
    private String email;
    private Phone phone;

    public Contact(String firstName, 
                   String lastName, 
                   String cpf, 
                   String date,
                   String address, 
                   String email, 
                   Phone phone){
        super(firstName, lastName, cpf, date, address);
        this.email = email;
        this.phone = phone;
    }
    
    public Contact(){
        this("","","","","","",null);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nome: ");
        str.append(super.toString());
        str.append("\n");
        
        str.append("Email: ");
        str.append(this.email);
        str.append("\n");
          
        str.append("Telefone:");
        str.append(this.phone.toString());
        str.append("\n");        

        return str.toString();
    }

    /**
     * @return the emailList
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the phoneList
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

}
