package askomdch.com.constants;

public enum EndPoint {
    HOME("/"),
    STORE("/store"),
    ACCOUNT("/account");

    public final String url;
    EndPoint(String url)
    {
        this.url = url;
    }
}
