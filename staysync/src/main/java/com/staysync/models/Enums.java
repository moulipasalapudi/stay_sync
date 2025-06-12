package com.staysync.models;

public class Enums {

    public enum TenantStatus {
        ACTIVE,
        CHECKOUT_REQUESTED,
        CHECKED_OUT
    }

    public enum Role {
        OWNER,
        TENANT,
        POTENTIAL_TENANT
    }
    public enum RequestStatus {
        PENDING,
        APPROVED,
        REJECTED
    }

    public enum ComplaintStatus {
        OPEN,
        RESOLVED
    }

    public enum BillStatus {
        UNPAID,
        PAID
    }
}