package twitter;

class TwitterAPIAuth
{
    // static variable single_instance of type Singleton
    private static TwitterAPIAuth single_instance = null;

    // variable of type String
    public String CONSUMER_KEY;
    public String CONSUMER_SECRET;
    public String ACCESS_TOKEN;
    public String ACCESS_TOKEN_SECRET;

    // private constructor restricted to this class itself
    private TwitterAPIAuth()
    {
        CONSUMER_KEY="ooR089Dty29SlzZgqMWtdPtr9";
        CONSUMER_SECRET="VzOPVwCFxv0QajLWYCTcUBRytWmwsdM42moPWBpSnkJ8rOMZVg";
        ACCESS_TOKEN="1281304163863977987-fVvFvSRC7SZfswoIByPk5qoaHYjNE2";
        ACCESS_TOKEN_SECRET="kpvIp2zeTLkhxPx9iMYpi6if7x418DGgsYoCYongH6Joi";

    }

    // static method to create instance of Singleton class
    public static TwitterAPIAuth getInstance()
    {
        if (single_instance == null)
            single_instance = new TwitterAPIAuth();

        return single_instance;
    }
}