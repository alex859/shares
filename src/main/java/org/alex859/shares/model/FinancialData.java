package org.alex859.shares.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public class FinancialData
{
   private BigDecimal revenue;
   private BigDecimal operatingProfit;
   private BigDecimal netInterest;
   private BigDecimal profitBeforeTax;
   private BigDecimal profitAfterTaxFromContinuingOperations;
   private BigDecimal profitAfterTaxFromDiscontinuingOperations;
   private BigDecimal profitForThePeriod;
   private BigDecimal profitAttributableToEquityHoldersOfParentCompany;
   private BigDecimal minorityInterestsOtherEquities;
   private BigDecimal totalDividendPaid;
   private BigDecimal retainedProfit;
   private BigDecimal basicEps;
   private BigDecimal dilutedEps;
   private BigDecimal adjustedEps;
   private BigDecimal dividendPerShare;
   private BigDecimal propertyPlantAndEquipment;
   private BigDecimal intangibleAssets;
   private BigDecimal investmentProperties;
   private BigDecimal investments;
   private BigDecimal otherFinancialAssets;
   private BigDecimal otherNonCurrentAssets;
   private BigDecimal inventories;
   private BigDecimal tradeAndOtherReceivables;
   private BigDecimal cashAtBankAndInHand;
   private BigDecimal currentAssetInvestments;
   private BigDecimal otherCurrentAssets;
   private BigDecimal otherAssets;
   private BigDecimal totalAssets;
   private BigDecimal currentBorrowings;
   private BigDecimal otherCurrentLiabilities;
   private BigDecimal netCurrentAssets;
   private BigDecimal nonCurrentBorrowings;
   private BigDecimal provisions;
   private BigDecimal otherNonCurrentLiabilities;
   private BigDecimal otherLiabilities;
   private BigDecimal totalLiabilities;
   private BigDecimal netAssets;
   private BigDecimal shareCapital;
   private BigDecimal sharePremiumAccount;
   private BigDecimal otherReserves;
   private BigDecimal retainedEarnings;
   private BigDecimal shareholdersFunds;
   private BigDecimal minorityInterestsOtherEquity;
   private BigDecimal totalEquity;

   private Date issueDate;

   public FinancialData()
   {

   }

   public FinancialData(final Date issueDate)
   {
      this.issueDate = issueDate;
   }

   public BigDecimal getAdjustedEps()
   {
      return adjustedEps;
   }

   public void setAdjustedEps(final BigDecimal adjustedEps)
   {
      this.adjustedEps = adjustedEps;
   }

   public BigDecimal getBasicEps()
   {
      return basicEps;
   }

   public void setBasicEps(final BigDecimal basicEps)
   {
      this.basicEps = basicEps;
   }

   public BigDecimal getCashAtBankAndInHand()
   {
      return cashAtBankAndInHand;
   }

   public void setCashAtBankAndInHand(final BigDecimal cashAtBankAndInHand)
   {
      this.cashAtBankAndInHand = cashAtBankAndInHand;
   }

   public BigDecimal getCurrentAssetInvestments()
   {
      return currentAssetInvestments;
   }

   public void setCurrentAssetInvestments(final BigDecimal currentAssetInvestments)
   {
      this.currentAssetInvestments = currentAssetInvestments;
   }

   public BigDecimal getCurrentBorrowings()
   {
      return currentBorrowings;
   }

   public void setCurrentBorrowings(final BigDecimal currentBorrowings)
   {
      this.currentBorrowings = currentBorrowings;
   }

   public BigDecimal getDilutedEps()
   {
      return dilutedEps;
   }

   public void setDilutedEps(final BigDecimal dilutedEps)
   {
      this.dilutedEps = dilutedEps;
   }

   public BigDecimal getDividendPerShare()
   {
      return dividendPerShare;
   }

   public void setDividendPerShare(final BigDecimal dividendPerShare)
   {
      this.dividendPerShare = dividendPerShare;
   }

   public BigDecimal getIntangibleAssets()
   {
      return intangibleAssets;
   }

   public void setIntangibleAssets(final BigDecimal intangibleAssets)
   {
      this.intangibleAssets = intangibleAssets;
   }

   public BigDecimal getInventories()
   {
      return inventories;
   }

   public void setInventories(final BigDecimal inventories)
   {
      this.inventories = inventories;
   }

   public BigDecimal getInvestmentProperties()
   {
      return investmentProperties;
   }

   public void setInvestmentProperties(final BigDecimal investmentProperties)
   {
      this.investmentProperties = investmentProperties;
   }

   public BigDecimal getInvestments()
   {
      return investments;
   }

   public void setInvestments(final BigDecimal investments)
   {
      this.investments = investments;
   }

   public BigDecimal getMinorityInterestsOtherEquity()
   {
      return minorityInterestsOtherEquity;
   }

   public void setMinorityInterestsOtherEquity(final BigDecimal minorityInterestsOtherEquity)
   {
      this.minorityInterestsOtherEquity = minorityInterestsOtherEquity;
   }

   public BigDecimal getMinorityInterestsOtherEquities()
   {
      return minorityInterestsOtherEquities;
   }

   public void setMinorityInterestsOtherEquities(final BigDecimal minorityInterestsOtherEquities)
   {
      this.minorityInterestsOtherEquities = minorityInterestsOtherEquities;
   }

   public BigDecimal getNetAssets()
   {
      return netAssets;
   }

   public void setNetAssets(final BigDecimal netAssets)
   {
      this.netAssets = netAssets;
   }

   public BigDecimal getNetCurrentAssets()
   {
      return netCurrentAssets;
   }

   public void setNetCurrentAssets(final BigDecimal netCurrentAssets)
   {
      this.netCurrentAssets = netCurrentAssets;
   }

   public BigDecimal getNetInterest()
   {
      return netInterest;
   }

   public void setNetInterest(final BigDecimal netInterest)
   {
      this.netInterest = netInterest;
   }

   public BigDecimal getNonCurrentBorrowings()
   {
      return nonCurrentBorrowings;
   }

   public void setNonCurrentBorrowings(final BigDecimal nonCurrentBorrowings)
   {
      this.nonCurrentBorrowings = nonCurrentBorrowings;
   }

   public BigDecimal getOperatingProfit()
   {
      return operatingProfit;
   }

   public void setOperatingProfit(final BigDecimal operatingProfit)
   {
      this.operatingProfit = operatingProfit;
   }

   public BigDecimal getOtherAssets()
   {
      return otherAssets;
   }

   public void setOtherAssets(final BigDecimal otherAssets)
   {
      this.otherAssets = otherAssets;
   }

   public BigDecimal getOtherCurrentAssets()
   {
      return otherCurrentAssets;
   }

   public void setOtherCurrentAssets(final BigDecimal otherCurrentAssets)
   {
      this.otherCurrentAssets = otherCurrentAssets;
   }

   public BigDecimal getOtherCurrentLiabilities()
   {
      return otherCurrentLiabilities;
   }

   public void setOtherCurrentLiabilities(final BigDecimal otherCurrentLiabilities)
   {
      this.otherCurrentLiabilities = otherCurrentLiabilities;
   }

   public BigDecimal getOtherFinancialAssets()
   {
      return otherFinancialAssets;
   }

   public void setOtherFinancialAssets(final BigDecimal otherFinancialAssets)
   {
      this.otherFinancialAssets = otherFinancialAssets;
   }

   public BigDecimal getOtherLiabilities()
   {
      return otherLiabilities;
   }

   public void setOtherLiabilities(final BigDecimal otherLiabilities)
   {
      this.otherLiabilities = otherLiabilities;
   }

   public BigDecimal getOtherNonCurrentAssets()
   {
      return otherNonCurrentAssets;
   }

   public void setOtherNonCurrentAssets(final BigDecimal otherNonCurrentAssets)
   {
      this.otherNonCurrentAssets = otherNonCurrentAssets;
   }

   public BigDecimal getOtherNonCurrentLiabilities()
   {
      return otherNonCurrentLiabilities;
   }

   public void setOtherNonCurrentLiabilities(final BigDecimal otherNonCurrentLiabilities)
   {
      this.otherNonCurrentLiabilities = otherNonCurrentLiabilities;
   }

   public BigDecimal getOtherReserves()
   {
      return otherReserves;
   }

   public void setOtherReserves(final BigDecimal otherReserves)
   {
      this.otherReserves = otherReserves;
   }

   public BigDecimal getProfitAfterTaxFromContinuingOperations()
   {
      return profitAfterTaxFromContinuingOperations;
   }

   public void setProfitAfterTaxFromContinuingOperations(final BigDecimal profitAfterTaxFromContinuingOperations)
   {
      this.profitAfterTaxFromContinuingOperations = profitAfterTaxFromContinuingOperations;
   }

   public BigDecimal getProfitAfterTaxFromDiscontinuingOperations()
   {
      return profitAfterTaxFromDiscontinuingOperations;
   }

   public void setProfitAfterTaxFromDiscontinuingOperations(final BigDecimal profitAfterTaxFromDiscontinuingOperations)
   {
      this.profitAfterTaxFromDiscontinuingOperations = profitAfterTaxFromDiscontinuingOperations;
   }

   public BigDecimal getProfitAttributableToEquityHoldersOfParentCompany()
   {
      return profitAttributableToEquityHoldersOfParentCompany;
   }

   public void setProfitAttributableToEquityHoldersOfParentCompany(final BigDecimal profitAttributableToEquityHoldersOfParentCompany)
   {
      this.profitAttributableToEquityHoldersOfParentCompany = profitAttributableToEquityHoldersOfParentCompany;
   }

   public BigDecimal getProfitBeforeTax()
   {
      return profitBeforeTax;
   }

   public void setProfitBeforeTax(final BigDecimal profitBeforeTax)
   {
      this.profitBeforeTax = profitBeforeTax;
   }

   public BigDecimal getProfitForThePeriod()
   {
      return profitForThePeriod;
   }

   public void setProfitForThePeriod(final BigDecimal profitForThePeriod)
   {
      this.profitForThePeriod = profitForThePeriod;
   }

   public BigDecimal getPropertyPlantAndEquipment()
   {
      return propertyPlantAndEquipment;
   }

   public void setPropertyPlantAndEquipment(final BigDecimal propertyPlantAndEquipment)
   {
      this.propertyPlantAndEquipment = propertyPlantAndEquipment;
   }

   public BigDecimal getProvisions()
   {
      return provisions;
   }

   public void setProvisions(final BigDecimal provisions)
   {
      this.provisions = provisions;
   }

   public BigDecimal getRetainedEarnings()
   {
      return retainedEarnings;
   }

   public void setRetainedEarnings(final BigDecimal retainedEarnings)
   {
      this.retainedEarnings = retainedEarnings;
   }

   public BigDecimal getRetainedProfit()
   {
      return retainedProfit;
   }

   public void setRetainedProfit(final BigDecimal retainedProfit)
   {
      this.retainedProfit = retainedProfit;
   }

   public BigDecimal getRevenue()
   {
      return revenue;
   }

   public void setRevenue(final BigDecimal revenue)
   {
      this.revenue = revenue;
   }

   public BigDecimal getShareCapital()
   {
      return shareCapital;
   }

   public void setShareCapital(final BigDecimal shareCapital)
   {
      this.shareCapital = shareCapital;
   }

   public BigDecimal getShareholdersFunds()
   {
      return shareholdersFunds;
   }

   public void setShareholdersFunds(final BigDecimal shareholdersFunds)
   {
      this.shareholdersFunds = shareholdersFunds;
   }

   public BigDecimal getSharePremiumAccount()
   {
      return sharePremiumAccount;
   }

   public void setSharePremiumAccount(final BigDecimal sharePremiumAccount)
   {
      this.sharePremiumAccount = sharePremiumAccount;
   }

   public BigDecimal getTotalAssets()
   {
      return totalAssets;
   }

   public void setTotalAssets(final BigDecimal totalAssets)
   {
      this.totalAssets = totalAssets;
   }

   public BigDecimal getTotalDividendPaid()
   {
      return totalDividendPaid;
   }

   public void setTotalDividendPaid(final BigDecimal totalDividendPaid)
   {
      this.totalDividendPaid = totalDividendPaid;
   }

   public BigDecimal getTotalEquity()
   {
      return totalEquity;
   }

   public void setTotalEquity(final BigDecimal totalEquity)
   {
      this.totalEquity = totalEquity;
   }

   public BigDecimal getTotalLiabilities()
   {
      return totalLiabilities;
   }

   public void setTotalLiabilities(final BigDecimal totalLiabilities)
   {
      this.totalLiabilities = totalLiabilities;
   }

   public BigDecimal getTradeAndOtherReceivables()
   {
      return tradeAndOtherReceivables;
   }

   public void setTradeAndOtherReceivables(final BigDecimal tradeAndOtherReceivables)
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
