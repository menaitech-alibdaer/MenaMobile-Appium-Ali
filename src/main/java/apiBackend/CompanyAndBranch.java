package apiBackend;

import bases.ApiBase;

import static utilities.MssqlConnect.selectQuery;

public class CompanyAndBranch extends ApiBase {

    private static int companyId = 0;
    private static int branchId = 0;

    public void setCompanyId(String companyCode){
        String company = selectQuery("select CompanyId from Companies where CompanyCode = '"+companyCode+"'");
        companyId = Integer.parseInt(company.trim());
    }

    public static int getCompanyId(){
        return companyId;
    }

    public void setBranchId(String branchCode){
        String branch = selectQuery("select BranchId from Branches where BranchCode = '"+branchCode+"' and CompanyId = "+getCompanyId()+";");
        branchId = Integer.parseInt(branch.trim());
    }

    public static int getBranchId(){
        return branchId;
    }
}
