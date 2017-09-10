/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.etiny.UserName;

/**
 *
 * @author Ice
 */
public interface UserNameInterface {
    public abstract boolean kiemTraUser(String userName, String passWord);
    public abstract boolean kiemTraUser(String userName);
    public abstract void register(UserName user);
}
