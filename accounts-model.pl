type_instance(money, decimal_type, [precision(19), scale(4)]).
type_instance(percent, decimal_type, [precision(6), scale(4), from(0), to(100)]).
type_instance(accountType, enumeration_type, [labels([])]).
type_instance(entryStatusType, enumeration_type, [labels([])]).
type_instance(currenciesType, enumeration_type, [labels([])]).
type_instance(partyType, enumeration_type, [labels([])]).
type_instance(taxSourceType, enumeration_type, [labels([])]).
type_instance(taxAccountingType, enumeration_type, [labels([])]).
type_instance(namedRef, view_type, [fields([property(name, string, "name")]), views([])]).
type_instance(account, entity_type, [fields([unique(key, fields([property(name, string, "name"), component_ref(parentAccount, account, true, _)])), property(description, string, "description"), property(type, accountType, "type"), property(balance, money, "balance"), collection(list, entries, no_parent, fields([component_ref(entry, entry, false, _)])), collection(set, taxTableEntries, no_parent, fields([component_ref(taxTableEntry, taxTableEntry, false, _)]))]), views([])]).
type_instance(entry, entity_type, [fields([component_ref(account, account, false, _), property(amount, money, "amount"), property(status, entryStatusType, "status"), collection(set, taxEntries, no_parent, fields([component_ref(taxEntry, taxEntry, false, _)]))]), views([])]).
type_instance(transaction, view_type, [fields([property(description, string, "description"), collection(list, entries, no_parent, fields([component_ref(entry, entry, false, _)])), property(date, date, "date")]), views([])]).
type_instance(taxedTransaction, view_type, [fields([collection(list, taxEntries, no_parent, fields([component_ref(taxEntry, taxEntry, false, _)]))]), views([])]).
type_instance(payable, view_type, [fields([component_ref(payment, basicTransaction, false, _)]), views([])]).
type_instance(basicTransaction, entity_type, [fields([property(description, string, "description"), collection(list, entries, no_parent, fields([component_ref(entry, entry, false, _)])), property(date, date, "date"), component_ref(invoice, invoice, false, _)]), views([transaction])]).
type_instance(party, entity_type, [fields([property(name, string, "name"), component_ref(address, address, false, _), property(type, partyType, "type"), collection(list, invoices, no_parent, fields([component_ref(invoices, invoice, false, _)]))]), views([])]).
type_instance(address, component_type, [fields([property(building, string, "building"), property(street, string, "street"), property(town, string, "town"), property(county, string, "county"), property(country, string, "country"), property(post_code, string, "post_code")]), views([])]).
type_instance(invoice, entity_type, [fields([property(description, string, "description"), property(invoiceNumber, integer, "invoiceNumber"), collection(list, entries, no_parent, fields([component_ref(entry, entry, false, _)])), collection(list, taxEntries, no_parent, fields([component_ref(taxEntry, taxEntry, false, _)])), property(date, date, "date"), property(due_date, date, "due_date"), component_ref(postingEntry, entry, false, _), component_ref(payment, basicTransaction, true, _), component_ref(party, party, false, _)]), views([transaction, taxedTransaction, payable])]).
type_instance(taxEntry, entity_type, [fields([component_ref(entry, entry, false, _), component_ref(taxEntry, taxTableEntry, false, _)]), views([])]).
type_instance(taxTable, entity_type, [fields([property(name, string, "name"), collection(list, rows, no_parent, fields([component_ref(entry, taxTableRow, false, _)]))]), views([])]).
type_instance(taxTableRow, entity_type, [fields([collection(list, entries, no_parent, fields([component_ref(entry, taxTableEntry, false, _)]))]), views([])]).
type_instance(taxTableEntry, entity_type, [fields([property(amount, percent, "amount"), property(sourceType, taxSourceType, "sourceType"), property(accountingType, taxAccountingType, "accountingType"), component_ref(account, account, false, _), collection(set, taxEntries, no_parent, fields([component_ref(taxEntry, taxEntry, false, _)]))]), views([])]).
