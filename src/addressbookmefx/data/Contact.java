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
import java.time.LocalDate;

/**
 *
 * @author MaJoy
 */
public class Contact implements Serializable, Comparable{
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthday;
    private String address;
    private String email;
    private Phone phone;
    public Contact(String firstName, String lastName, String cpf, LocalDate birthday,
                   String address,   String email,    Phone phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf; 
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    
     public String getFullName() {
        return this.getFirstName()+" "+this.getLastName();
    }

    @Override
    public String toString(){
       return this.getFullName();
    }    
    public Contact(){
        this("","","",null,"","",null);
    }
    public String exportText(){        
        return "\n| Nome: "      + this.getFullName()+
               "\n| CPF: "       + this.getCpf()+
               "\n| Nascimento: "+ this.getBirthDay()+
               "\n| Endereço: "  +this.getAddress()+
               "\n| Email: "     +this.getEmail()+
               "\n| Telefone: "  +this.getPhone().toString()+
               "\n-----------------------------------------------\n";       
    }
     /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the birthDay
     */
    public LocalDate getBirthDay() {
        return birthday;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(LocalDate birthDay) {
        this.birthday = birthDay;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public int compareTo(Object o) {
        
        Contact other = (Contact) o;
        return this.getFullName().compareTo(other.getFullName());       
    }
}
