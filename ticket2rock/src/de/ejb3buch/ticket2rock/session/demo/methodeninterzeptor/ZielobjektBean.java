/**
 *  Ticket2Rock ist die Beispielanwendung des Buchs "EJB 3.1 professionell" (dpunkt).
 *  Es implementiert eine einfache Webanwendung zur Onlinebuchung von Tickets f�r
 *  Rockkonzerten. 
 *
 *  Copyright (C) 2011
 *  Jo Ehm, Stefan M. Heldt, Oliver Ihns, Holger Koschek,
 *  Carsten Sahling, Roman Schloemmer, Norman Erck, Daniel Steinh�fer,
 *  Carl A. D�vel.
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package de.ejb3buch.ticket2rock.session.demo.methodeninterzeptor;

import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.interceptor.Interceptors;

import de.ejb3buch.ticket2rock.entity.demo.Enti;
import de.ejb3buch.ticket2rock.session.demo.ZielobjektBase;

@Stateless(name = "ZielobjektBeanMethodeninterzeptor")
public class ZielobjektBean extends ZielobjektBase {

	@Interceptors(de.ejb3buch.ticket2rock.session.interceptor.demo.Abfangjaeger.class)
	public void fangMichAb() {
		super.fangMichAb();
	}

	@Interceptors(de.ejb3buch.ticket2rock.session.interceptor.demo.Abfangjaeger.class)
	public String michAuch(Object obj) {
		return super.michAuch(obj);
	}

	@Interceptors(de.ejb3buch.ticket2rock.session.interceptor.demo.Abfangjaeger.class)
	public void duKriegstMichNicht() {
		super.duKriegstMichNicht();
	}

	// Hier verzichten wir auf die @Interceptors-Annotation, weil diese Methode
	// nicht abgefangen werden soll
	public void lassMichInRuhe() {
	}

	@Interceptors(de.ejb3buch.ticket2rock.session.interceptor.demo.Abfangjaeger.class)
	public void gibMirZeit() {
		super.gibMirZeit();
	}

	@Interceptors(de.ejb3buch.ticket2rock.session.interceptor.demo.Abfangjaeger.class)
	public Enti bruete() {
		return super.bruete();
	}

	@Timeout
	protected void deineZeitIstAbgelaufen(Timer timer) {
		super.deineZeitIstAbgelaufen(timer);
	}
}
