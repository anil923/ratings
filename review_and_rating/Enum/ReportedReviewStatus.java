package com.gdc.review_and_rating.Enum;

public enum ReportedReviewStatus {
    // Newly reported, not yet reviewed
    PENDING,

    // Currently under review
    UNDER_REVIEW,

    // Report approved and action taken
    APPROVED,

    // Report rejected
    REJECTED,

    // Review deleted
    DELETED
}
