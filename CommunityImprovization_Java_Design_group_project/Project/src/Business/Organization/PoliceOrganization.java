/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PoliceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pruth
 */
public class PoliceOrganization extends Organization{
    public PoliceOrganization() {
        super(CrimeType.Police.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRoles = new ArrayList<Role>();
        supportedRoles.add(new PoliceRole());
        return supportedRoles;
    }
}
