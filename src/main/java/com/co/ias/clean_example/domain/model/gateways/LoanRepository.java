package com.co.ias.clean_example.domain.model.gateways;

import com.co.ias.clean_example.domain.model.Loan;

public interface LoanRepository {

    Loan saveLoan(Loan loan);
}
