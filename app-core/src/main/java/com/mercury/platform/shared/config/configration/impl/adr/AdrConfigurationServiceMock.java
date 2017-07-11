package com.mercury.platform.shared.config.configration.impl.adr;


import com.mercury.platform.shared.config.configration.BaseConfigurationService;
import com.mercury.platform.shared.config.configration.ListConfigurationService;
import com.mercury.platform.shared.config.descriptor.ProfileDescriptor;
import com.mercury.platform.shared.config.descriptor.adr.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AdrConfigurationServiceMock extends BaseConfigurationService<List<AdrProfileDescriptor>> implements ListConfigurationService<AdrProfileDescriptor>{
    public AdrConfigurationServiceMock(ProfileDescriptor selectedProfile) {
        super(selectedProfile);
    }

    @Override
    public List<AdrProfileDescriptor> getEntities() {
        return this.getDefault();
    }


    @Override
    public List<AdrProfileDescriptor> getDefault() {
        AdrProfileDescriptor profile = new AdrProfileDescriptor();
        profile.setSelected(true);
        AdrGroupDescriptor groupDescriptor = new AdrGroupDescriptor();
        groupDescriptor.setSize(new Dimension(64,64));
        groupDescriptor.setLocation(new Point(400,400));
        groupDescriptor.setGroupType(AdrGroupType.STATIC);
        groupDescriptor.setType(AdrComponentType.GROUP);

        AdrIconDescriptor icon1 = new AdrIconDescriptor();
        icon1.setIconPath("Arctic_Armour_skill_icon");
        icon1.setLocation(new Point(400, 400));
        icon1.setSize(new Dimension(64, 64));
        icon1.setDuration(8f);
        icon1.setIconType(AdrIconType.SQUARE);
        icon1.setType(AdrComponentType.ICON);
        AdrIconDescriptor icon2 = new AdrIconDescriptor();
        icon2.setIconPath("Blood_Rage_skill_icon");
        icon2.setLocation(new Point(400, 400));
        icon2.setSize(new Dimension(64, 64));
        icon2.setDuration(8f);
        icon2.setIconType(AdrIconType.SQUARE);
        icon2.setType(AdrComponentType.ICON);
        AdrIconDescriptor icon3 = new AdrIconDescriptor();
        icon3.setIconPath("Bismuth_Flask");
        icon3.setLocation(new Point(400, 400));
        icon3.setSize(new Dimension(64, 64));
        icon3.setDuration(8f);
        icon3.setIconType(AdrIconType.ELIPSE);
        icon3.setType(AdrComponentType.ICON);
        groupDescriptor.setCells(Arrays.asList(icon1,icon2,icon3,icon2));

        AdrGroupDescriptor groupDescriptor1 = new AdrGroupDescriptor();
        groupDescriptor1.setSize(new Dimension(64,64));
        groupDescriptor1.setLocation(new Point(500,500));
        groupDescriptor1.setType(AdrComponentType.GROUP);
        groupDescriptor1.setGroupType(AdrGroupType.DYNAMIC);
        groupDescriptor1.setCells(Arrays.asList(icon3,icon1,icon2,icon3));
        profile.setContents(Arrays.asList(groupDescriptor,groupDescriptor1, icon1,groupDescriptor,icon3));
        return Arrays.asList(profile);
    }

    @Override
    public void toDefault() {
        this.selectedProfile.setAdrProfileDescriptorList(this.getDefault());
    }

    @Override
    public void validate() {
        if(this.selectedProfile.getAdrProfileDescriptorList() == null){
            this.selectedProfile.setAdrProfileDescriptorList(this.getDefault());
        }
    }
}
