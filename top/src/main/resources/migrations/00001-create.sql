
    create table account (
        id int8 not null,
        name text,
        parentAccount_id int8,
        description text,
        type_id int8,
        balance numeric(19, 4),
        primary key (id)
    );

    create table accountType_enumeration (
        id int8 not null,
        accountType varchar(255),
        primary key (id)
    );

    create table basicTransaction (
        id int8 not null,
        description text,
        date date,
        primary key (id)
    );

    create table basicTransaction_entry (
        basicTransaction_id int8 not null,
        entry_id int8 not null,
        entries_index int4 not null,
        primary key (basicTransaction_id, entries_index)
    );

    create table currenciesType_enumeration (
        id int8 not null,
        currenciesType varchar(255),
        primary key (id)
    );

    create table entry (
        id int8 not null,
        account_id int8,
        amount numeric(19, 4),
        status_id int8,
        entries_index int4,
        primary key (id)
    );

    create table entryStatusType_enumeration (
        id int8 not null,
        entryStatusType varchar(255),
        primary key (id)
    );

    create table external_id (
        id char(32),
        resource varchar(255),
        primary key (id)
    );

    create table invoice (
        id int8 not null,
        description text,
        invoiceNumber int4,
        date date,
        due_date date,
        postingEntry_id int8,
        payment_id int8,
        party_id int8,
        invoices_index int4,
        primary key (id)
    );

    create table invoice_entry (
        invoice_id int8 not null,
        entry_id int8 not null,
        entries_index int4 not null,
        primary key (invoice_id, entries_index)
    );

    create table invoice_taxEntry (
        invoice_id int8 not null,
        taxEntry_id int8 not null,
        taxEntries_index int4 not null,
        primary key (invoice_id, taxEntries_index)
    );

    create table party (
        id int8 not null,
        name text,
        addressBuilding text,
        addressStreet text,
        addressTown text,
        addressCounty text,
        addressCountry text,
        addressPostCode text,
        type_id int8,
        primary key (id)
    );

    create table partyType_enumeration (
        id int8 not null,
        partyType varchar(255),
        primary key (id)
    );

    create table taxAccountingType_enumeration (
        id int8 not null,
        taxAccountingType varchar(255),
        primary key (id)
    );

    create table taxEntry (
        id int8 not null,
        entry_id int8,
        taxEntry_id int8,
        taxTableEntry_id int8,
        primary key (id)
    );

    create table taxSourceType_enumeration (
        id int8 not null,
        taxSourceType varchar(255),
        primary key (id)
    );

    create table taxTable (
        id int8 not null,
        name text,
        primary key (id)
    );

    create table taxTableEntry (
        id int8 not null,
        amount numeric(6, 4),
        sourceType_id int8,
        accountingType_id int8,
        account_id int8,
        primary key (id)
    );

    create table taxTableRow (
        id int8 not null,
        primary key (id)
    );

    create table taxTableRow_taxTableEntry (
        taxTableRow_id int8 not null,
        taxTableEntry_id int8 not null,
        entries_index int4 not null,
        primary key (taxTableRow_id, entries_index)
    );

    create table taxTable_taxTableRow (
        taxTable_id int8 not null,
        taxTableRow_id int8 not null,
        rows_index int4 not null,
        primary key (taxTable_id, rows_index)
    );

    alter table invoice 
        add constraint UK_5vvlr4mmb6jbwiu4dyqwevd0d  unique (payment_id);

    alter table account 
        add constraint FK_3bx2sv9ydmw2nb2pnkoj5yd1n 
        foreign key (parentAccount_id) 
        references account;

    alter table account 
        add constraint FK_20ngi6xl7sf0y2s8kgd1wbjb 
        foreign key (type_id) 
        references accountType_enumeration;

    alter table basicTransaction_entry 
        add constraint FK_iivgnp7sqjfctjl48vo6yo2xy 
        foreign key (entry_id) 
        references entry;

    alter table basicTransaction_entry 
        add constraint FK_o669kiixru0ac23ao1dw6muqa 
        foreign key (basicTransaction_id) 
        references basicTransaction;

    alter table entry 
        add constraint FK_tdsfwn9yhonehv8681v7maub 
        foreign key (account_id) 
        references account;

    alter table entry 
        add constraint FK_b8ft0q6nya2wq7j5l1678oaed 
        foreign key (status_id) 
        references entryStatusType_enumeration;

    alter table invoice 
        add constraint FK_r37678icft3cvot9pttrh9606 
        foreign key (postingEntry_id) 
        references entry;

    alter table invoice 
        add constraint FK_5vvlr4mmb6jbwiu4dyqwevd0d 
        foreign key (payment_id) 
        references basicTransaction;

    alter table invoice 
        add constraint FK_kbf7tyamry2uug29gk5avhqjs 
        foreign key (party_id) 
        references party;

    alter table invoice_entry 
        add constraint FK_u4b25bteth6gscafqjjrhv66 
        foreign key (entry_id) 
        references entry;

    alter table invoice_entry 
        add constraint FK_scoums0kh295f3gfrrthi9ymj 
        foreign key (invoice_id) 
        references invoice;

    alter table invoice_taxEntry 
        add constraint FK_keanidspchovracfiye8yaabt 
        foreign key (taxEntry_id) 
        references taxEntry;

    alter table invoice_taxEntry 
        add constraint FK_bmoxdirio7nsrtc689fe37yig 
        foreign key (invoice_id) 
        references invoice;

    alter table party 
        add constraint FK_fg8h7ywqw65nd386n8egxuf8c 
        foreign key (type_id) 
        references partyType_enumeration;

    alter table taxEntry 
        add constraint FK_dypwg1m1xu2kclxsedua2pcwu 
        foreign key (entry_id) 
        references entry;

    alter table taxEntry 
        add constraint FK_m6p7p1af0lo5jg2yx9stoy0mt 
        foreign key (taxEntry_id) 
        references taxTableEntry;

    alter table taxEntry 
        add constraint FK_5kv6cmoomi1j8bmphvxmtelc6 
        foreign key (taxTableEntry_id) 
        references taxTableEntry;

    alter table taxTableEntry 
        add constraint FK_dn86ih2fq5x863xmcttul3m7r 
        foreign key (sourceType_id) 
        references taxSourceType_enumeration;

    alter table taxTableEntry 
        add constraint FK_d2e8ds1kkac99sxb1jh18idv5 
        foreign key (accountingType_id) 
        references taxAccountingType_enumeration;

    alter table taxTableEntry 
        add constraint FK_tg1x4bofshxonl8x1dyjg2u06 
        foreign key (account_id) 
        references account;

    alter table taxTableRow_taxTableEntry 
        add constraint FK_dgb4xfi8v5o0riebbskvb1w50 
        foreign key (taxTableEntry_id) 
        references taxTableEntry;

    alter table taxTableRow_taxTableEntry 
        add constraint FK_nw6t0nefy2barl06whjk22vpl 
        foreign key (taxTableRow_id) 
        references taxTableRow;

    alter table taxTable_taxTableRow 
        add constraint FK_l7o76u0jseefihsq2yjaufkax 
        foreign key (taxTableRow_id) 
        references taxTableRow;

    alter table taxTable_taxTableRow 
        add constraint FK_k1h2x3ar449holxxv0g58imo8 
        foreign key (taxTable_id) 
        references taxTable;

    create sequence hibernate_sequence;
