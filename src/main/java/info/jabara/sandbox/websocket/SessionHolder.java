/**
 * 
 */
package info.jabara.sandbox.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.websocket.Session;

/**
 * @author jabaraster
 */
@Singleton
public class SessionHolder implements Iterable<Session> {
    private final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    /**
     * @param pSession -
     */
    public void add(final Session pSession) {
        this.sessions.add(pSession);
        jabara.Debug.write("session count -> " + this.sessions.size()); //$NON-NLS-1$
    }

    /**
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Session> iterator() {
        jabara.Debug.write("session count -> " + this.sessions.size()); //$NON-NLS-1$
        return this.sessions.iterator();
    }

    /**
     * 
     */
    @SuppressWarnings("static-method")
    @PostConstruct
    public void postConstruct() {
        jabara.Debug.write();
    }

    /**
     * @param pSession -
     */
    public void remove(final Session pSession) {
        this.sessions.remove(pSession);
        jabara.Debug.write("session count -> " + this.sessions.size()); //$NON-NLS-1$
    }

}
