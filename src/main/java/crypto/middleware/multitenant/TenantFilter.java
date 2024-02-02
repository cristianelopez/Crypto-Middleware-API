package crypto.middleware.multitenant;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class TenantFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
