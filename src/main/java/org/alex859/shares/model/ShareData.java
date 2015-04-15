package org.alex859.shares.model;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * Class to model data we have about a share
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
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
    private String isin;
    private String epic;
    private Double price;
    private String currency;
    private String category;
    private String subCategory;
    private FinancialData lastFinancialData;
    private List<FinancialData> financialData;

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

    public String getIsin()
    {
        return isin;
    }

    public void setIsin(final String isin)
    {
        this.isin = isin;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(final String currency)
    {
        this.currency = currency;
    }

    public String getEpic()
    {
        return epic;
    }

    public void setEpic(final String epic)
    {
        this.epic = epic;
    }

    public List<FinancialData> getFinancialData()
    {
        return financialData;
    }

    public void setFinancialData(final List<FinancialData> financialData)
    {
        this.financialData = financialData;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(final Double price)
    {
        this.price = price;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(final String category)
    {
        this.category = category;
    }

    public String getSubCategory()
    {
        return subCategory;
    }

    public void setSubCategory(final String subCategory)
    {
        this.subCategory = subCategory;
    }

    public FinancialData getLastFinancialData()
    {
        return lastFinancialData;
    }

    public void setLastFinancialData(final FinancialData lastFinancialData)
    {
        this.lastFinancialData = lastFinancialData;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("epic", epic)
                .add("financial data size", financialData != null ? financialData.size() : 0)
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

        if (!isin.equals(shareData.isin))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return isin.hashCode();
    }
}
