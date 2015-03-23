package org.alex859.shares.model;

import com.google.common.base.MoreObjects;

/**
 * Class to model data we have about a share
 * @author alex859 (alessandro.ciccimarra@gmail.com).
 */
public class ShareData
{
    private String symbol;
    private String name;
    /**
     * @see <a href='http://www.investopedia.com/terms/s/sedol.asp'>SEDOL</a>
     */
    private String sedol;
    private String url;

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(final String symbol)
    {
        this.symbol = symbol;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getSedol()
    {
        return sedol;
    }

    public void setSedol(final String sedol)
    {
        this.sedol = sedol;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(final String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("sedol", sedol)
                .add("url", url)
                .toString();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ShareData))
        {
            return false;
        }

        final ShareData shareData = (ShareData) o;

        if (!sedol.equals(shareData.sedol))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return sedol.hashCode();
    }
}
