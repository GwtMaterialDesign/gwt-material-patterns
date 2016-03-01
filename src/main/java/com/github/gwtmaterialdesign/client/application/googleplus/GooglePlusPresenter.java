package com.github.gwtmaterialdesign.client.application.googleplus;

import com.github.gwtmaterialdesign.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class GooglePlusPresenter extends Presenter<GooglePlusPresenter.MyView, GooglePlusPresenter.MyProxy> {
    interface MyView extends View {
    }

    @NameToken(NameTokens.google_plus)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<GooglePlusPresenter> {
    }


    @Inject
    GooglePlusPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);

    }

}
