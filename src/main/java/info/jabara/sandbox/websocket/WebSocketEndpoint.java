/**
 * 
 */
package info.jabara.sandbox.websocket;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author jabaraster
 */
@ServerEndpoint("/socket/endpoint")
public class WebSocketEndpoint {

    /**
     * {@link WebSocketEndpoint}自身をSingletonにしてみたが、有効にならなかった.
     */
    @Inject
    SessionHolder sessions;

    /**
     * @param pSession -
     */
    @OnClose
    public void onClose(final Session pSession) {
        this.sessions.remove(pSession);
    }

    /**
     * @param pMessage -
     * @param pSession -
     */
    @OnMessage
    public void onMessage(final String pMessage, final Session pSession) {
        jabara.Debug.write(pSession);
        for (final Session session : this.sessions) {
            session.getAsyncRemote().sendText(pMessage);
        }
    }

    /**
     * @param pSession
     */
    @OnOpen
    public void onOpen(final Session pSession) {
        this.sessions.add(pSession);
    }
}
