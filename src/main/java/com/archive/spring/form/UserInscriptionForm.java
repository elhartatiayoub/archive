/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archive.spring.form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import com.archive.spring.form.constraint.FieldMatch;
import javax.validation.constraints.Size;

/**
 *
 * @author Iob
 */

@FieldMatch(first = "password", second = "confPass", message = "typeMismatch")
public class UserInscriptionForm {
    
    @Email
    @NotNull
    String email;
    @NotNull
    @Size(min = 3, max = 15)
    String username;
    @Size(min = 6, max = 32)
    @NotNull
    String password;
    @Size(min = 6, max = 32)
    @NotNull
    String confPass;
    
}
