package askomdch.com.customtype;

import askomdch.com.workobject.Product;
import io.cucumber.java.ParameterType;

public class customParameterType {

    @ParameterType(".*")
    public Product product(String name)
    {
        return  new Product(name.replace("\"",""));
    }
}
