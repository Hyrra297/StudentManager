/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.etiny;

import java.util.Comparator;

/**
 *
 * @author Ice
 */
public class KetQuaComparator implements Comparator<KetQua>{

    @Override
    public int compare(KetQua o1, KetQua o2) {
        return o2.getMaMH().compareTo(o1.getMaMH());
    }

    
    
}
