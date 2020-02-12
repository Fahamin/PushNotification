package fahim.doa.pushnotification;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyfirebaseInstanceIdservice extends FirebaseInstanceIdService {

    private static final String ttag = "myfirebaseinstan";

    @Override
    public void onTokenRefresh() {
        String refreshtoken = FirebaseInstanceId.getInstance().getToken();

    }
}
