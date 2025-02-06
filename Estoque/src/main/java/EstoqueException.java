/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */

/**
 *
 * @author Eduardo
 */
public class EstoqueException extends Exception {

    /**
     * Creates a new instance of <code>CadastroException</code> without detail
     * message.
     */
    public EstoqueException() {
    }

    /**
     * Constructs an instance of <code>CadastroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EstoqueException(String msg) {
        super(msg);
    }
}
