/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author Алексей
 */
public class PhoneNumber {
    private String areaCode;
    private String localNum;

    public PhoneNumber(String areaCode, String localNum) {
        check(areaCode, "Area code");
        check(localNum, "Local number");
        this.areaCode = areaCode;
        this.localNum = localNum;
    }
    private void check(String attrVal, String attrName) {
        if(attrVal == null || attrVal.isBlank())
            throw new IllegalArgumentException(attrName + " is empty.");
        for(int i = 0; i < attrVal.length(); i++) {
            if(!Character.isDigit(attrVal.charAt(i)))
                throw new IllegalArgumentException(attrName + " must contain digits only.");
        }
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getLocalNum() {
        return localNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, localNum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhoneNumber other = (PhoneNumber) obj;
        if (!Objects.equals(this.areaCode, other.areaCode)) {
            return false;
        }
        if (!Objects.equals(this.localNum, other.localNum)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "(" + areaCode + ")" + localNum;
    }
}
