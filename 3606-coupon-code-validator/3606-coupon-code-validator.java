import java.util.*;

class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // Step 1: Define the allowed business lines in required order
        List<String> order = Arrays.asList(
            "electronics", "grocery", "pharmacy", "restaurant"
        );

        // Step 2: List to store valid coupons (businessLine + code)
        List<String[]> validCoupons = new ArrayList<>();

        // Step 3: Check each coupon
        for (int i = 0; i < code.length; i++) {

            // Rule 1: Coupon must be active
            if (!isActive[i]) {
                continue;
            }

            // Rule 2: Code must not be empty
            if (code[i] == null || code[i].isEmpty()) {
                continue;
            }

            // Rule 3: Code must contain only letters, numbers, and underscore
            if (!code[i].matches("[a-zA-Z0-9_]+")) {
                continue;
            }

            // Rule 4: Business line must be valid
            if (!order.contains(businessLine[i])) {
                continue;
            }

            // If all rules pass, store the coupon
            validCoupons.add(new String[]{businessLine[i], code[i]});
        }

        // Step 4: Sort valid coupons
        Collections.sort(validCoupons, (a, b) -> {
            int businessCompare =
                order.indexOf(a[0]) - order.indexOf(b[0]);

            if (businessCompare != 0) {
                return businessCompare;
            }

            // If same business line, sort by code alphabetically
            return a[1].compareTo(b[1]);
        });

        // Step 5: Extract only coupon codes
        List<String> result = new ArrayList<>();
        for (String[] coupon : validCoupons) {
            result.add(coupon[1]);
        }

        return result;
    }
}
