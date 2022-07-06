package query;

import java.util.ArrayList;

public class QueryByProvince extends QueryByPlace {
    private String queryInput;

    public QueryByProvince(String provinceInput) {
        super();
        ArrayList<String> infoList = getInfoList();
        infoList.add("?s dbp:province ?province.");
        infoList.add("?s dbp:nearestCity ?nearestCity.");
        infoList.add("?s dbp:nativeName ?nativeName.");
        infoList.add("?s dbp:nativeNameLang ?nativeNameLang.");
        infoList.add("?s dbp:operator ?operator.");
        infoList.add("?s dbp:owner ?owner.");
        infoList.add("?s dbp:tenants ?tenants.");
        this.queryInput = provinceInput.replace(" ", "_");
    }

    @Override
    public String getOutName() {
        return "Tourist_attractions_in_" + queryInput;
    }

    @Override
    public String getPagesByTopic() {
        return "?s dct:subject/skos:broader* dbc:Tourist_attractions_in_" + queryInput + ".";
    }
}
