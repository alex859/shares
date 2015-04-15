package org.alex859.shares.model;

import java.util.Date;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public class FinancialData
{
   private Double revenue;
   private Double operatingProfit;
   private Double netInterest;
   private Double profitBeforeTax;
   private Double profitAfterTaxFromContinuingOperations;
   private Double profitAfterTaxFromDiscontinuingOperations;
   private Double profitForThePeriod;
   private Double profitAttributableToEquityHoldersOfParentCompany;
   private Double minorityInterestsOtherEquities;
   private Double totalDividendPaid;
   private Double retainedProfit;
   private Double basicEps;
   private Double dilutedEps;
   private Double adjustedEps;
   private Double dividendPerShare;
   private Double propertyPlantAndEquipment;
   private Double intangibleAssets;
   private Double investmentProperties;
   private Double investments;
   private Double otherFinancialAssets;
   private Double otherNonCurrentAssets;
   private Double inventories;
   private Double tradeAndOtherReceivables;
   private Double cashAtBankAndInHand;
   private Double currentAssetInvestments;
   private Double otherCurrentAssets;
   private Double otherAssets;
   private Double totalAssets;
   private Double currentBorrowings;
   private Double otherCurrentLiabilities;
   private Double netCurrentAssets;
   private Double nonCurrentBorrowings;
   private Double provisions;
   private Double otherNonCurrentLiabilities;
   private Double otherLiabilities;
   private Double totalLiabilities;
   private Double netAssets;
   private Double shareCapital;
   private Double sharePremiumAccount;
   private Double otherReserves;
   private Double retainedEarnings;
   private Double shareholdersFunds;
   private Double minorityInterestsOtherEquity;
   private Double totalEquity;

   private Date issueDate;

   public FinancialData()
   {

   }

   public FinancialData(final Date issueDate)
   {
      this.issueDate = issueDate;
   }

   public Double getAdjustedEps()
   {
      return adjustedEps;
   }

   public void setAdjustedEps(final Double adjustedEps)
   {
      this.adjustedEps = adjustedEps;
   }

   public Double getBasicEps()
   {
      return basicEps;
   }

   public void setBasicEps(final Double basicEps)
   {
      this.basicEps = basicEps;
   }

   public Double getCashAtBankAndInHand()
   {
      return cashAtBankAndInHand;
   }

   public void setCashAtBankAndInHand(final Double cashAtBankAndInHand)
   {
      this.cashAtBankAndInHand = cashAtBankAndInHand;
   }

   public Double getCurrentAssetInvestments()
   {
      return currentAssetInvestments;
   }

   public void setCurrentAssetInvestments(final Double currentAssetInvestments)
   {
      this.currentAssetInvestments = currentAssetInvestments;
   }

   public Double getCurrentBorrowings()
   {
      return currentBorrowings;
   }

   public void setCurrentBorrowings(final Double currentBorrowings)
   {
      this.currentBorrowings = currentBorrowings;
   }

   public Double getDilutedEps()
   {
      return dilutedEps;
   }

   public void setDilutedEps(final Double dilutedEps)
   {
      this.dilutedEps = dilutedEps;
   }

   public Double getDividendPerShare()
   {
      return dividendPerShare;
   }

   public void setDividendPerShare(final Double dividendPerShare)
   {
      this.dividendPerShare = dividendPerShare;
   }

   public Double getIntangibleAssets()
   {
      return intangibleAssets;
   }

   public void setIntangibleAssets(final Double intangibleAssets)
   {
      this.intangibleAssets = intangibleAssets;
   }

   public Double getInventories()
   {
      return inventories;
   }

   public void setInventories(final Double inventories)
   {
      this.inventories = inventories;
   }

   public Double getInvestmentProperties()
   {
      return investmentProperties;
   }

   public void setInvestmentProperties(final Double investmentProperties)
   {
      this.investmentProperties = investmentProperties;
   }

   public Double getInvestments()
   {
      return investments;
   }

   public void setInvestments(final Double investments)
   {
      this.investments = investments;
   }

   public Double getMinorityInterestsOtherEquity()
   {
      return minorityInterestsOtherEquity;
   }

   public void setMinorityInterestsOtherEquity(final Double minorityInterestsOtherEquity)
   {
      this.minorityInterestsOtherEquity = minorityInterestsOtherEquity;
   }

   public Double getMinorityInterestsOtherEquities()
   {
      return minorityInterestsOtherEquities;
   }

   public void setMinorityInterestsOtherEquities(final Double minorityInterestsOtherEquities)
   {
      this.minorityInterestsOtherEquities = minorityInterestsOtherEquities;
   }

   public Double getNetAssets()
   {
      return netAssets;
   }

   public void setNetAssets(final Double netAssets)
   {
      this.netAssets = netAssets;
   }

   public Double getNetCurrentAssets()
   {
      return netCurrentAssets;
   }

   public void setNetCurrentAssets(final Double netCurrentAssets)
   {
      this.netCurrentAssets = netCurrentAssets;
   }

   public Double getNetInterest()
   {
      return netInterest;
   }

   public void setNetInterest(final Double netInterest)
   {
      this.netInterest = netInterest;
   }

   public Double getNonCurrentBorrowings()
   {
      return nonCurrentBorrowings;
   }

   public void setNonCurrentBorrowings(final Double nonCurrentBorrowings)
   {
      this.nonCurrentBorrowings = nonCurrentBorrowings;
   }

   public Double getOperatingProfit()
   {
      return operatingProfit;
   }

   public void setOperatingProfit(final Double operatingProfit)
   {
      this.operatingProfit = operatingProfit;
   }

   public Double getOtherAssets()
   {
      return otherAssets;
   }

   public void setOtherAssets(final Double otherAssets)
   {
      this.otherAssets = otherAssets;
   }

   public Double getOtherCurrentAssets()
   {
      return otherCurrentAssets;
   }

   public void setOtherCurrentAssets(final Double otherCurrentAssets)
   {
      this.otherCurrentAssets = otherCurrentAssets;
   }

   public Double getOtherCurrentLiabilities()
   {
      return otherCurrentLiabilities;
   }

   public void setOtherCurrentLiabilities(final Double otherCurrentLiabilities)
   {
      this.otherCurrentLiabilities = otherCurrentLiabilities;
   }

   public Double getOtherFinancialAssets()
   {
      return otherFinancialAssets;
   }

   public void setOtherFinancialAssets(final Double otherFinancialAssets)
   {
      this.otherFinancialAssets = otherFinancialAssets;
   }

   public Double getOtherLiabilities()
   {
      return otherLiabilities;
   }

   public void setOtherLiabilities(final Double otherLiabilities)
   {
      this.otherLiabilities = otherLiabilities;
   }

   public Double getOtherNonCurrentAssets()
   {
      return otherNonCurrentAssets;
   }

   public void setOtherNonCurrentAssets(final Double otherNonCurrentAssets)
   {
      this.otherNonCurrentAssets = otherNonCurrentAssets;
   }

   public Double getOtherNonCurrentLiabilities()
   {
      return otherNonCurrentLiabilities;
   }

   public void setOtherNonCurrentLiabilities(final Double otherNonCurrentLiabilities)
   {
      this.otherNonCurrentLiabilities = otherNonCurrentLiabilities;
   }

   public Double getOtherReserves()
   {
      return otherReserves;
   }

   public void setOtherReserves(final Double otherReserves)
   {
      this.otherReserves = otherReserves;
   }

   public Double getProfitAfterTaxFromContinuingOperations()
   {
      return profitAfterTaxFromContinuingOperations;
   }

   public void setProfitAfterTaxFromContinuingOperations(final Double profitAfterTaxFromContinuingOperations)
   {
      this.profitAfterTaxFromContinuingOperations = profitAfterTaxFromContinuingOperations;
   }

   public Double getProfitAfterTaxFromDiscontinuingOperations()
   {
      return profitAfterTaxFromDiscontinuingOperations;
   }

   public void setProfitAfterTaxFromDiscontinuingOperations(final Double profitAfterTaxFromDiscontinuingOperations)
   {
      this.profitAfterTaxFromDiscontinuingOperations = profitAfterTaxFromDiscontinuingOperations;
   }

   public Double getProfitAttributableToEquityHoldersOfParentCompany()
   {
      return profitAttributableToEquityHoldersOfParentCompany;
   }

   public void setProfitAttributableToEquityHoldersOfParentCompany(final Double profitAttributableToEquityHoldersOfParentCompany)
   {
      this.profitAttributableToEquityHoldersOfParentCompany = profitAttributableToEquityHoldersOfParentCompany;
   }

   public Double getProfitBeforeTax()
   {
      return profitBeforeTax;
   }

   public void setProfitBeforeTax(final Double profitBeforeTax)
   {
      this.profitBeforeTax = profitBeforeTax;
   }

   public Double getProfitForThePeriod()
   {
      return profitForThePeriod;
   }

   public void setProfitForThePeriod(final Double profitForThePeriod)
   {
      this.profitForThePeriod = profitForThePeriod;
   }

   public Double getPropertyPlantAndEquipment()
   {
      return propertyPlantAndEquipment;
   }

   public void setPropertyPlantAndEquipment(final Double propertyPlantAndEquipment)
   {
      this.propertyPlantAndEquipment = propertyPlantAndEquipment;
   }

   public Double getProvisions()
   {
      return provisions;
   }

   public void setProvisions(final Double provisions)
   {
      this.provisions = provisions;
   }

   public Double getRetainedEarnings()
   {
      return retainedEarnings;
   }

   public void setRetainedEarnings(final Double retainedEarnings)
   {
      this.retainedEarnings = retainedEarnings;
   }

   public Double getRetainedProfit()
   {
      return retainedProfit;
   }

   public void setRetainedProfit(final Double retainedProfit)
   {
      this.retainedProfit = retainedProfit;
   }

   public Double getRevenue()
   {
      return revenue;
   }

   public void setRevenue(final Double revenue)
   {
      this.revenue = revenue;
   }

   public Double getShareCapital()
   {
      return shareCapital;
   }

   public void setShareCapital(final Double shareCapital)
   {
      this.shareCapital = shareCapital;
   }

   public Double getShareholdersFunds()
   {
      return shareholdersFunds;
   }

   public void setShareholdersFunds(final Double shareholdersFunds)
   {
      this.shareholdersFunds = shareholdersFunds;
   }

   public Double getSharePremiumAccount()
   {
      return sharePremiumAccount;
   }

   public void setSharePremiumAccount(final Double sharePremiumAccount)
   {
      this.sharePremiumAccount = sharePremiumAccount;
   }

   public Double getTotalAssets()
   {
      return totalAssets;
   }

   public void setTotalAssets(final Double totalAssets)
   {
      this.totalAssets = totalAssets;
   }

   public Double getTotalDividendPaid()
   {
      return totalDividendPaid;
   }

   public void setTotalDividendPaid(final Double totalDividendPaid)
   {
      this.totalDividendPaid = totalDividendPaid;
   }

   public Double getTotalEquity()
   {
      return totalEquity;
   }

   public void setTotalEquity(final Double totalEquity)
   {
      this.totalEquity = totalEquity;
   }

   public Double getTotalLiabilities()
   {
      return totalLiabilities;
   }

   public void setTotalLiabilities(final Double totalLiabilities)
   {
      this.totalLiabilities = totalLiabilities;
   }

   public Double getTradeAndOtherReceivables()
   {
      return tradeAndOtherReceivables;
   }

   public void setTradeAndOtherReceivables(final Double tradeAndOtherReceivables)
   {
      this.tradeAndOtherReceivables = tradeAndOtherReceivables;
   }

   public Date getIssueDate()
   {
      return issueDate;
   }

   public void setIssueDate(final Date issueDate)
   {
      this.issueDate = issueDate;
   }
}
