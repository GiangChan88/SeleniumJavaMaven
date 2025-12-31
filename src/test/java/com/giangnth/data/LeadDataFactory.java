package com.giangnth.data;

import com.giangnth.helpers.ExcelHelper;
import com.giangnth.models.LeadDTO;

public class LeadDataFactory {
    //Get 1 dòng data trong file excel được chỉ định
    public static LeadDTO getLeadDataFromExcel(int rowIndex) {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/DataCRM.xlsx", "Lead");

        LeadDTO lead = new LeadDTO();
        lead.setLeadName(excel.getCellData("LeadName", rowIndex));
        lead.setStatus(excel.getCellData("Status", rowIndex));
        lead.setSource(excel.getCellData("Source", rowIndex));
        lead.setAssigned(excel.getCellData("Assigned", rowIndex));
        lead.setTags(excel.getCellData("Tags", rowIndex));
        lead.setAddress(excel.getCellData("Address", rowIndex));
        lead.setPosition(excel.getCellData("Position", rowIndex));
        lead.setCity(excel.getCellData("City", rowIndex));
        lead.setEmailAddress(excel.getCellData("EmailAddress", rowIndex));
        lead.setState(excel.getCellData("State", rowIndex));
        lead.setWebsite(excel.getCellData("Website", rowIndex));
        lead.setCountry(excel.getCellData("Country", rowIndex));
        lead.setPhone(excel.getCellData("Phone", rowIndex));
        lead.setZipcode(excel.getCellData("Zipcode", rowIndex));
        lead.setLeadValue(excel.getCellData("LeadValue", rowIndex));
        lead.setLanguage(excel.getCellData("Language", rowIndex));
        lead.setCompany(excel.getCellData("Company", rowIndex));
        lead.setDescription(excel.getCellData("Description", rowIndex));
        lead.setDateContacted(excel.getCellData("DateContacted", rowIndex));
        lead.setFlagEdit(Integer.parseInt(excel.getCellData("FlagEdit", rowIndex)));
        lead.setTypeConfirm(Integer.parseInt(excel.getCellData("TypeConfirm", rowIndex)));

        return lead;
    }

}
