var $mvt = new Object({
    A: "1.4.13.5", r: undefined, X: "length", hI: document, x: {}, hO: "_mvq", z: function (a, b) {
        this.hC = a;
        this.M = b
    }, U: function (a) {
        return ($mvt.r == a) || ("-" == a) || ("" == a)
    }, $IsEmpty: function (a) {
        return $mvt.U(a)
    }, o: function (a, b) {
        return a.indexOf(b)
    }, I: function (a, b, c) {
        c = ($mvt.r == c) ? a[$mvt.X] : c;
        return a.substring(b, c)
    }, G: function (a, b) {
        return $mvt.o(a, b) > -1
    }, hy: function (a) {
        var f = false, e = 0, c, b;
        if (!$mvt.U(a)) {
            f = true;
            for (c = 0; c < a[$mvt.X]; c++) {
                b = a.charAt(c);
                e += "." == b ? 1 : 0;
                f = f && e <= 1 && (0 == c && "-" == b || $mvt.G(".0123456789", b))
            }
        }
        return f
    }, F: function (b) {
        var a = 1, d = 0, e, c;
        if (!$mvt.U(b)) {
            a = 0;
            for (e = b[$mvt.X] - 1; e >= 0; e--) {
                c = b.charCodeAt(e);
                a = (a << 6 & 268435455) + c + (c << 14);
                d = a & 266338304;
                a = (d != 0) ? a ^ d >> 21 : a
            }
        }
        return a
    }, R: function (c, a, f) {
        var b = "-", e, d;
        if (!$mvt.U(c) && !$mvt.U(a) && !$mvt.U(f)) {
            e = $mvt.o(c, a);
            if (e > -1) {
                d = c.indexOf(f, e);
                if (d < 0) {
                    d = c[$mvt.X]
                }
                b = $mvt.I(c, e + $mvt.o(a, "=") + 1, d)
            }
        }
        return b
    }, $ExtractValue: function (b, a, c) {
        return $mvt.R(b, a, c)
    }, p: function (c, a) {
        var b = encodeURIComponent;
        return b instanceof Function ? (a ? encodeURI(c) : b(c)) : escape(c)
    }, w: function (b, a) {
        var e = decodeURIComponent, d;
        b = b.split("+").join(" ");
        if (e instanceof Function) {
            try {
                d = a ? decodeURI(b) : e(b)
            } catch (c) {
                d = unescape(b)
            }
        } else {
            d = unescape(b)
        }
        return d
    }, hk: function (a) {
        return a && a.hash ? $mvt.I(a.href, $mvt.o(a.href, "#")) : ""
    }, P: function (a) {
        return a[$mvt.X] > 0 && $mvt.G(" \n\r\t", a)
    }, hR: function (a, b) {
        a[a[$mvt.X]] = b
    }, hc: function (a) {
        return a.toLowerCase()
    }, Z: function (a, b) {
        return a.split(b)
    }, hS: function () {
        return Math.round(Math.random() * 2147483647)
    }, hi: function () {
        var b = $mvt.r;
        var a = window;
        if (a && a.hm && a.hm.hp) {
            b = a.hm.hp
        } else {
            b = $mvt.hS();
            a.hm = a.hm ? a.hm : {};
            a.hm.hp = b
        }
        return b
    }, rA: function () {
        var b, e, g, c, a;
        var d = window;
        var f = $mvt.hI;
        var h = navigator;
        b = f.cookie ? f.cookie : "";
        e = d.history[$mvt.X];
        a = [h.appName, h.version, h.language ? h.language : h.browserLanguage, h.platform, h.userAgent, h.javaEnabled() ? 1 : 0].join("");
        if (d.screen) {
            a += d.screen.width + "x" + d.screen.height + d.screen.colorDepth
        } else {
            if (d.java) {
                c = java.rz.rh.rM().rq();
                a += c.screen.width + "x" + c.screen.height
            }
        }
        a += b;
        a += f.referrer ? f.referrer : "";
        g = a[$mvt.X];
        while (e > 0) {
            a += e-- ^ g++
        }
        return $mvt.F(a)
    }, rU: function () {
        return ($mvt.hS() ^ $mvt.rA()) * 2147483647
    }, rD: function (e, g) {
        var a = (new Date).getTime();
        var c = "jsonp" + a + Math.floor(Math.random() * 10000);
        e = e + "&cb=" + c;
        window[c] = window[c] || function (h) {
            d(h);
            window[c] = undefined;
            try {
                delete window[c]
            } catch (i) {
            }
            if (b) {
                b.removeChild(f)
            }
        };
        var b = document.getElementsByTagName("head")[0] || document.documentElement;
        var f = document.createElement("script");
        f.src = e;
        b.insertBefore(f, b.firstChild);

        function d(h) {
            if (typeof (g) == "function") {
                g(h)
            }
        }
    }
});
$mvt.rB = function () {
    rJ = this;
    rJ.ry = "http://tran.mediav.com/t";
    rJ.rd = "http://pv.mediav.com/t";
    rJ.rY = "https://secure.mediav.com/t";
    rJ.rF = "15768000";
    rJ.rW = "1800";
    rJ.rk = [new $mvt.z("baidu", "word"), new $mvt.z("baidu", "wd"), new $mvt.z("google", "q"), new $mvt.z("sogou", "query"), new $mvt.z("zhongsou", "w"), new $mvt.z("soso", "w"), new $mvt.z("search.114.vnet.cn", "kw"), new $mvt.z("youdao", "q"), new $mvt.z("gougou", "search"), new $mvt.z("bing", "q"), new $mvt.z("msn", "q"), new $mvt.z("live", "q"), new $mvt.z("aol", "query"), new $mvt.z("aol", "q"), new $mvt.z("aol", "encquery"), new $mvt.z("lycos", "query"), new $mvt.z("ask", "q"), new $mvt.z("altavista", "q"), new $mvt.z("netscape", "query"), new $mvt.z("cnn", "query"), new $mvt.z("looksmart", "qt"), new $mvt.z("about", "terms"), new $mvt.z("pchome", "q")];
    rJ.rR = "/";
    rJ.rL = 1;
    rJ.rc = 1;
    rJ.rS = "|";
    rJ.ri = 1;
    rJ.rp = 0;
    rJ.rm = "auto"
};
$mvt.rT = false;
$mvt.rw = function (p, c) {
    var m = c;
    var k = p;
    var d = this;
    var r, b, e, n, l, o, q;

    function f(t) {
        var s = (t instanceof Array) ? t.join(".") : "-";
        return $mvt.U(s) ? "-" : s
    }

    function i(t, s) {
        var v = [], u;
        if (!$mvt.U(t)) {
            v = $mvt.Z(t, ".");
            if (s) {
                for (u = 0; u < v[$mvt.X]; u++) {
                    if (!$mvt.hy(v[u])) {
                        v[u] = "-"
                    }
                }
            }
        }
        return v
    }

    function g(s) {
        var t = new Date, u = new Date(t.getTime() + s);
        return "expires=" + u.toGMTString() + "; "
    }

    function a() {
        return g(63072000000)
    }

    function j(s, t) {
        k.cookie = s + "; path=" + m.rR + "; " + t + d.Xl()
    }

    function h(t, u, v) {
        var x = d.Xq, w, s;
        for (w = 0; w < x[$mvt.X]; w++) {
            s = x[w][0];
            s += $mvt.U(u) ? u : u + x[w][4];
            x[w][2]($mvt.R(t, s, v))
        }
    }

    d.XD = function () {
        return $mvt.r == q || q == d.Xo()
    };
    d.Xv = function () {
        return q ? q : "-"
    };
    d.XI = function (s) {
        q = $mvt.hy(s) ? s * 1 : "-"
    };
    d.XO = function () {
        return f(r)
    };
    d.XC = function (s) {
        r = i(s, true)
    };
    d.XG = function () {
        return f(b)
    };
    d.Xb = function (s) {
        b = i(s, true)
    };
    d.XB = function () {
        return f(e)
    };
    d.XJ = function (s) {
        e = i(s, true)
    };
    d.Xy = function () {
        return f(n)
    };
    d.Xd = function (s) {
        n = i(s);
        for (var t = 0; t < n[$mvt.X]; t++) {
            if (t < 4 && !$mvt.hy(n[t])) {
                n[t] = "-"
            }
        }
    };
    d.XY = function (s) {
        if (!$mvt.U(s)) {
            j("_jzqosr=" + s, g($mvt.rT * 1000 || 63072000000 / 2))
        }
    };
    d.XF = function () {
        return f(l)
    };
    d.XW = function (s) {
        l = i(s);
        for (var t = 0; t < l[$mvt.X]; t++) {
            if (t < 4 && !$mvt.hy(l[t])) {
                l[t] = "-"
            }
        }
    };
    d.Xk = function () {
        return f(o)
    };
    d.XR = function (s) {
        o = i(s);
        for (var t = 0; t < o[$mvt.X]; t++) {
            if (t < 4 && !$mvt.hy(o[t])) {
                o[t] = "-"
            }
        }
    };
    d.XL = function (t, s) {
        if (t == "_jzqx=") {
            d.Xd(s);
            d.Xi()
        } else {
            if (t == "_jzqy=") {
                d.XW(s);
                d.Xp()
            } else {
                if (t == "_jzqz=") {
                    d.XR(s);
                    d.Xm()
                }
            }
        }
    };
    d.Xl = function () {
        return $mvt.U(m.rm) ? "" : "domain=" + m.rm + ";"
    };
    d.XT = function () {
        r = [];
        b = [];
        e = [];
        n = [];
        l = [];
        o = [];
        q = $mvt.r
    };
    d.Xo = function () {
        var s = "", t;
        for (t = 0; t < d.Xq[$mvt.X]; t++) {
            s += d.Xq[t][1]()
        }
        return $mvt.F(s)
    };
    d.Xw = function (u) {
        var t = k.cookie, s = false;
        if (t) {
            h(t, u, ";");
            d.XI(d.Xo());
            s = true
        }
        return s
    };
    d.XN = function () {
        j("_jzqckmp=1", g(86400000))
    };
    d.Xg = function () {
        j("_jzqa=" + d.XO(), a())
    };
    d.Xn = function () {
        j("_jzqb=" + d.XG(), g(m.rW * 1000))
    };
    d.XV = function () {
        j("_jzqc=" + d.XB(), "")
    };
    d.Xi = function () {
        j("_jzqx=" + d.Xy(), g(m.rF * 1000))
    };
    d.Xp = function () {
        j("_jzqy=" + d.XF(), g(m.rF * 1000))
    };
    d.Xm = function () {
        j("_jzqz=" + d.Xk(), g(m.rF * 1000))
    };
    d.Xq = [["_jzqa=", d.XO, d.XC, d.Xg, "."], ["_jzqb=", d.XG, d.Xb, d.Xn, ""], ["_jzqc=", d.XB, d.XJ, d.XV, ""], ["_jzqx=", d.Xy, d.Xd, d.Xi, ""], ["_jzqy=", d.XF, d.XW, d.Xp, "."], ["_jzqz=", d.Xk, d.XR, d.Xm, ""]]
};
$mvt.XP = function (d) {
    var c = d;
    var b;
    var f = this;
    var e = false;
    var a;
    Xe = function (g) {
        var i = (new Date).getTime(), h;
        h = (i - g[3]) * (0.2 / 1000);
        if (h >= 1) {
            g[2] = Math.min(Math.floor(g[2] * 1 + h), 10);
            g[3] = i
        }
        return g
    };
    f.XK = function (g) {
        f.Xj.XK(g, f.Xu)
    };
    f.Xs = function (s, n, h, t, i, u) {
        var j, m = h.location;
        if (!f.Xu) {
            f.Xu = new $mvt.rw(h, c)
        }
        f.Xu.Xw(t);
        j = $mvt.Z(f.Xu.XG(), ".");
        if (j[1] < 500 || i) {
            j[1] = j[1] * 1 + 1;
            var r = $mvt.hI.location.search;
            var q = $mvt.R(r, "_mvsrc=", "&");
            var l = $mvt.R(r, "_mvcam=", "&");
            var p = $mvt.hI.cookie, o = $mvt.R(window.location.href, "_mvosr=", "&");
            $mvt.U(o) && (o = $mvt.R(p, "_jzqosr=", ";"));
            f.Xf = f.Xf && (j[4] == "0");
            s = "?type=" + (i ? 3 : 6) + "&db=none" + ($mvt.U(q) ? "" : "&pub=" + q) + ($mvt.U(l) ? "" : "&cus=" + l) + ($mvt.U(o) ? "" : "&jzqosr=" + o) + "&jzqv=" + $mvt.A + "&jzqrd=" + ((window._mv_loader && window._mv_loader["getRandom"] && window._mv_loader["getRandom"]("mv")) || $mvt.hS()) + ($mvt.U(m.hostname) ? "" : "&jzqh=" + $mvt.p(m.hostname)) + "&jzqs=" + n + "&jzqc=" + f.HM(h, t, $mvt.G(s, "jzqt=item")) + s;
            var g = "";
            if ("https:" == m.protocol) {
                g = c.rY + s
            } else {
                g = (i ? c.ry : c.rd) + s
            }
            if (i) {
                var k = new Image(1, 1);
                k.onload = k.onerror = u || function () {
                };
                window["mediav_" + (new Date() - 0)] = k;
                k.src = g
            } else {
                f.XK(g)
            }
        }
        f.Xu.Xb(j.join("."));
        f.Xu.Xn()
    };
    f.HM = function (i, n, o) {
        var h = [], m = ["_jzqa=", "_jzqx=", "_jzqy=", "_jzqz="], j, l = i.cookie, k;
        var g = m[$mvt.X];
        if (o) {
            g = 1
        }
        for (j = 0; j < g; j++) {
            k = $mvt.R(l, m[j] + n, ";");
            if (!$mvt.U(k)) {
                $mvt.hR(h, m[j] + k + ";")
            }
        }
        return $mvt.p(h.join("+"))
    }
};
$mvt.HG = function () {
    this.Hb = []
};
$mvt.HG.HB = function (b, a, f, e, c) {
    var d = this;
    d.HW = b;
    d.Hk = a;
    d.HR = f;
    d.HL = e;
    d.Hc = c
};
$mvt.HG.HB.prototype.HS = function () {
    var a = this;
    return "&" + ["jzqt=item", "jzqo=" + $mvt.p(a.HW), "jzqix=" + $mvt.p(a.Hk), "jzqin=" + $mvt.p(a.HR), "jzqip=" + $mvt.p(a.HL), "jzqiq=" + $mvt.p(a.Hc)].join("&")
};
$mvt.HG.Hi = function (d, f, a, e, c, b) {
    var g = this;
    g.HW = d;
    g.HN = f;
    g.Hg = a;
    g.Hn = e;
    g.HV = c;
    g.HP = b;
    g.Hu = []
};
$mvt.HG.Hi.prototype.Hf = function (a, f, e, c) {
    var d = this;
    var b = d.He(a);
    if ($mvt.r == b) {
        $mvt.hR(d.Hu, new $mvt.HG.HB(d.HW, a, f, e, c))
    } else {
        b.Hk = a;
        b.HR = f;
        b.HL = e;
        b.Hc = c
    }
};
$mvt.HG.Hi.prototype.He = function (a) {
    var d = this;
    var b;
    for (var c = 0; c < d.Hu[$mvt.X]; c++) {
        b = (a == d.Hu[c].Hk) ? d.Hu[c] : b
    }
    return b
};
$mvt.HG.Hi.prototype.HS = function () {
    var a = this;
    return "&jzqt=tran&jzqo=" + $mvt.p(a.HW) + "&jzqot=" + $mvt.p(a.HN) + ($mvt.U(a.Hg) ? "" : "&jzqo1=" + $mvt.p(a.Hg)) + ($mvt.U(a.Hn) ? "" : "&jzqo2=" + $mvt.p(a.Hn)) + ($mvt.U(a.HV) ? "" : "&jzqo3=" + $mvt.p(a.HV)) + ($mvt.U(a.HP) ? "" : "&jzqo4=" + $mvt.p(a.HP))
};
$mvt.HG.prototype.HZ = function (d, g, a, e, c, b) {
    var h = this;
    var f = h.HK(d);
    if ($mvt.r == f) {
        f = new $mvt.HG.Hi(d, g, a, e, c, b);
        $mvt.hR(h.Hb, f)
    } else {
        f.HN = g;
        f.Hg = a;
        f.Hn = e;
        f.HV = c;
        f.HP = b
    }
    return f
};
$mvt.HG.prototype.HK = function (a) {
    var b;
    var d = this;
    for (var c = 0; c < d.Hb[$mvt.X]; c++) {
        b = (a == d.Hb[c].HW) ? d.Hb[c] : b
    }
    return b
};
$mvt.Hs = function (c) {
    var b = c;
    var d = this;
    d.Ht = !self.screen && self.java ? java.rz.rh.rM() : $mvt.r;
    d.xA = "-";
    d.xr = "-";
    d.xX = "-";
    d.xH = "-";
    d.xx = 1;
    d.xl = "-";

    function a() {
        var f, l = navigator ? navigator.plugins : $mvt.r;
        var h;
        if (l && l[$mvt.X] > 0) {
            for (var m = 0; m < l[$mvt.X] && !h; m++) {
                f = l[m];
                if ($mvt.G(f.name, "Shockwave Flash")) {
                    h = $mvt.Z(f.description, "Shockwave Flash ")[1]
                }
            }
        } else {
            var e = "ShockwaveFlash.ShockwaveFlash";
            var j = "$version";
            var k;
            try {
                k = new ActiveXObject(e + ".7");
                h = k.xv(j)
            } catch (i) {
            }
            if (!h) {
                try {
                    k = new ActiveXObject(e + ".6");
                    h = "WIN 6,0,21,0";
                    k.xI = "always";
                    h = k.xv(j)
                } catch (i) {
                }
            }
            if (!h) {
                try {
                    k = new ActiveXObject(e);
                    h = k.xv(j)
                } catch (i) {
                }
            }
            if (h) {
                h = $mvt.Z($mvt.Z(h, " ")[1], ",");
                h = h[0] + "." + h[1] + " r" + h[2]
            }
        }
        return h ? h : "-"
    }

    d.XT = function () {
        var e;
        var h = $mvt.hI;
        var i = navigator;
        if (self.screen) {
            d.xA = screen.width + "x" + screen.height;
            d.xr = screen.colorDepth + "-bit"
        } else {
            if (d.Ht) {
                try {
                    e = d.Ht.rq();
                    d.xA = e.width + "x" + e.height
                } catch (f) {
                }
            }
        }
        d.xH = $mvt.hc(i && i.language ? i.language : (i && i.browserLanguage ? i.browserLanguage : "-"));
        d.xx = i && i.javaEnabled() ? 1 : 0;
        d.xl = b ? a() : "-";
        d.xX = $mvt.p(h.characterSet ? h.characterSet : (h.charset ? h.charset : "-"))
    };
    d.HS = function () {
        return "&" + ["jzqch=" + $mvt.p(d.xX), "jzqsc=" + d.xA, "jzqco=" + d.xr, "jzql=" + d.xH, "jzqj=" + d.xx, "jzqf=" + $mvt.p(d.xl)].join("&")
    }
};
$mvt.xO = function (n, c, f, d, j) {
    var k = c;
    var q = n;
    var h = f;
    var a = d;
    var m = j;
    var b = this;
    var p = true;
    var o;
    var g;

    function e(r) {
        return $mvt.U(r) || "0" == r || !$mvt.G(r, "://")
    }

    function i(s) {
        var r = "";
        s = $mvt.hc($mvt.Z(s, "://")[1]);
        if ($mvt.G(s, "/")) {
            s = $mvt.Z(s, "/")[1];
            if ($mvt.G(s, "?")) {
                r = $mvt.Z(s, "?")[0]
            }
        }
        return r
    }

    function l(s) {
        var r = "";
        r = $mvt.hc($mvt.Z(s, "://")[1]);
        if ($mvt.G(r, "/")) {
            r = $mvt.Z(r, "/")[0]
        }
        return r
    }

    b.xL = function (s) {
        var r = $mvt.R(s, "_mvsrc=", "&");
        if ($mvt.U(r)) {
            r = $mvt.R(s, "_mvmix=", "&")
        }
        var t = new $mvt.xO.xS("(camp)", r, $mvt.R(s, "_mvcam=", "&"));
        b.xy = !b.xi(t);
        return t
    };
    b.xp = function (s) {
        var v, r, t = s || h, u, x, w = m.rk;
        if (e(t)) {
            return
        }
        v = l(t);
        for (u = 0; u < w[$mvt.X]; u++) {
            x = w[u];
            if ($mvt.G(v, $mvt.hc(x.hC))) {
                t = $mvt.Z(t, "?").join("&");
                if ($mvt.G(t, "&" + x.M + "=")) {
                    r = $mvt.Z(t, "&" + x.M + "=")[1];
                    if ($mvt.G(r, "&")) {
                        r = $mvt.Z(r, "&")[0]
                    }
                    return new $mvt.xO.xS("(search)", x.hC, r)
                }
            }
        }
    };
    b.xN = function (s) {
        var r = "", u = "", t = s || h;
        if (e(t)) {
            return
        }
        r = $mvt.hc($mvt.Z(t, "://")[1]);
        if ($mvt.G(r, "/")) {
            u = $mvt.I(r, $mvt.o(r, "/"));
            if ($mvt.G(u, "?")) {
                u = $mvt.Z(u, "?")[0]
            }
            r = $mvt.Z(r, "/")[0]
        }
        if (0 == $mvt.o(r, "www.")) {
            r = $mvt.I(r, 4)
        }
        return new $mvt.xO.xS("(ref)", r, u)
    };
    b.xV = function (r) {
        var s = "";
        s += r.search;
        return s
    };
    b.xi = function (r) {
        return $mvt.r != r && r.xu()
    };
    b.xf = function (y, A, v, s, B, t) {
        var z, r, x = 1, w;
        if (t == $mvt.r) {
            t = a
        }
        y = y || o;
        if (!b.xi(s)) {
            return false
        }
        if ("_jzqz=" == v) {
            b.lX(y, "1")
        }
        z = $mvt.R(A, v + q + ".", ";");
        if ($mvt.U(z)) {
            y.XL(v, [q, t, t, x, s.HS(), "-"].join("."));
            return true
        }
        r = $mvt.Z(z, ".");
        var u = new $mvt.xO.xS;
        if ($mvt.U(r[5])) {
            u.XT(r.slice(4, 5).join("."))
        } else {
            u.XT(r.slice(5).join("."))
        }
        w = $mvt.hc(u.HS()) == $mvt.hc(s.HS());
        x = r[3] * 1;
        if (!w || B) {
            if (!w) {
                x++;
                y.XL(v, [q, r[1], t, x, r[4], s.HS()].join("."))
            } else {
                y.XL(v, [q, r[1], t, x, r[4], r[5]].join("."))
            }
        }
        return true
    };
    b.lx = function (w, B) {
        var y = "", t, x, v = 1, u, z;
        var s = "-", A = "-", r = "-";
        w = w || o;
        o = w;
        b.xY = B;
        z = k.cookie ? k.cookie : "";
        y = b.xV(k.location);
        t = b.xL(y);
        b.xf(w, z, "_jzqz=", t, B);
        t = b.xp();
        if (b.xf(w, z, "_jzqy=", t, B)) {
            return ""
        }
        if (!B) {
            return ""
        }
        t = b.xN();
        b.xf(w, z, "_jzqx=", t, B);
        return ""
    };
    b.lX = function (s, t) {
        var r = $mvt.Z(s.XG(), ".");
        r[4] = t;
        s.Xb(r.join("."));
        s.Xn()
    };
    b.XK = function (s, r) {
        $mvt.rD(s, function (A) {
            try {
                var y = $mvt.R(window.location.href, "_mvosr=", "&");
                if (!$mvt.U(y)) {
                    r.XY(y)
                }
                if ($mvt.lo) {
                    return
                }
                A = "status=" + A.replace("_mvctn=", "");
                var x = $mvt.R(A, "status=", "&");
                if (x == "0") {
                    var w = b.xY;
                    var C = k.cookie ? k.cookie : "";
                    var B = A;
                    var u = b.xL(B);
                    var v = $mvt.R(B, "time=", "&");
                    var t = $mvt.R(B, "rdom=", "&");
                    if ($mvt.U(y)) {
                        y = $mvt.R(B, "osr=", "&")
                    }
                    r.XY(y);
                    b.xf(r, C, "_jzqz=", u, w, v);
                    try {
                        t = decodeURIComponent(t)
                    } catch (z) {
                        t = ""
                    }
                    if (t != "") {
                        u = b.xp(t);
                        b.xf(r, C, "_jzqy=", u, w, v);
                        u = b.xN(t);
                        b.xf(r, C, "_jzqx=", u, w, v)
                    }
                }
                if (x != "2") {
                    b.lX(r, 1)
                }
            } catch (z) {
            }
            $mvt.lo = 1
        })
    }
};
$mvt.xO.xS = function (b, c, a) {
    this.lb = c;
    this.lB = a
};
$mvt.xO.xS.prototype.HS = function () {
    var e = this;
    var d = [], a = [["jzqsr=", e.lb], ["jzqct=", e.lB.substr(0, 100)]], c, b;
    if (e.xu()) {
        for (c = 0; c < a[$mvt.X]; c++) {
            if (!$mvt.U(a[c][1])) {
                b = a[c][1].split("+").join("%20");
                b = b.split(" ").join("%20");
                b = b.split(".").join("%2E");
                b = b.split("|").join("%7C");
                $mvt.hR(d, a[c][0] + b)
            }
        }
    }
    return d.join("|")
};
$mvt.xO.xS.prototype.xu = function () {
    return !($mvt.U(this.lb) && $mvt.U(this.lB))
};
$mvt.xO.xS.prototype.XT = function (a) {
    ld = function (b) {
        return $mvt.R(a, b, "|")
    };
    this.lb = ld("jzqsr=");
    this.lB = ld("jzqct=")
};
$mvt.$site = function ($s, $g) {
    var a = this, c = $mvt.r, d = new $mvt.rB, f = false;
    a.xs = Math.round((new Date).getTime() / 1000);
    a.lk = $s;
    a.referrer = $mvt.hI.referrer;
    a.lR = $mvt.r;
    a.lL = $mvt.r;
    a.xK = false;
    a.lc = $mvt.r;
    a.lS = $mvt.r;
    a.li = $mvt.r;

    function e() {
        if ("auto" == d.rm) {
            var i = $mvt.hI.location.host;
            if ("www." == $mvt.I(i, 0, 4)) {
                i = $mvt.I(i, 4)
            } else {
                var j = i.split(".");
                var k = j[j.length - 1];
                if (j.length > 2 && isNaN(k - 0)) {
                    j[0] = "";
                    i = j.join(".")
                }
            }
            d.rm = i
        }
        d.rm = $mvt.hc(d.rm)
    }

    function b(l, m, j) {
        if ($mvt.U(l) || $mvt.U(m) || $mvt.U(j)) {
            return "-"
        }
        var i = $mvt.R(l, "_jzqa=" + a.lS + ".", m), k;
        if (!$mvt.U(i)) {
            k = $mvt.Z(i, ".");
            k[5] = k[5] ? k[5] * 1 + 1 : 1;
            k[3] = k[4];
            k[4] = j;
            i = k.join(".")
        }
        return i
    }

    function g() {
        return "file:" != $mvt.hI.location.protocol
    }

    function h(i) {
        if (!i || "" == i) {
            return ""
        }
        while ($mvt.P(i.charAt(0))) {
            i = $mvt.I(i, 1)
        }
        while ($mvt.P(i.charAt(i[$mvt.X] - 1))) {
            i = $mvt.I(i, 0, i[$mvt.X] - 1)
        }
        return i
    }

    a.lf = function () {
        if (!d.rm || "" == d.rm || "none" == d.rm) {
            d.rm = "";
            return 1
        }
        e();
        return d.rp ? $mvt.F(d.rm) : 1
    };
    a.lj = function (j, i) {
        if ($mvt.U(j)) {
            j = "-"
        }
        return j
    };
    a.le = function (k) {
        var i = "";
        var j = $mvt.hI;
        i += a.lc ? a.lc.HS() : "";
        i += d.rL && !$mvt.U(j.title) ? "&jzqpt=" + $mvt.p(h(j.title)) : "";
        i += "&jzqre=" + $mvt.p(a.lR).substr(0, 100) + "&jzqp=" + $mvt.p(a.lZ(k));
        return i
    };
    a.lZ = function (j) {
        var i = $mvt.hI.location;
        j = j || (i.pathname + i.search);
        return j
    };
    a.lE = function (j) {
        var i = "";
        i += a.le(j);
        c.Xs(i, a.lk, $mvt.hI, a.lS)
    };
    a.lK = function () {
        var s = $mvt.hI.cookie, n = a.xs, t = a.lS + "", j, l = $mvt.G(s, "_jzqa=" + t + "."),
            p = $mvt.G(s, "_jzqb=" + t), o = $mvt.G(s, "_jzqc=" + t), q, m = [], k = "", r = false, i;
        s = $mvt.U(s) ? "" : s;
        if (l) {
            if (!p || !o) {
                q = b(s, ";", n);
                a.xK = true
            } else {
                q = $mvt.R(s, "_jzqa=" + t + ".", ";");
                m = $mvt.Z($mvt.R(s, "_jzqb=" + t, ";"), ".")
            }
        } else {
            q = [t, $mvt.rU(), n, n, n, 1].join(".");
            a.xK = true;
            r = true
        }
        q = $mvt.Z(q, ".");
        a.li.XC(q.join("."));
        m[0] = t;
        m[1] = m[1] ? m[1] : 0;
        m[2] = $mvt.r != m[2] ? m[2] : 10;
        m[3] = m[3] ? m[3] : q[4];
        m[4] = $mvt.r != m[4] ? m[4] : 0;
        a.li.Xb(m.join("."));
        a.li.XJ(t);
        if (!$mvt.U(a.li.Xv())) {
            a.li.XI(a.li.Xo())
        }
        a.li.Xg();
        a.li.Xn();
        a.li.XV()
    };
    a.zh = function () {
        c = new $mvt.XP(d)
    };
    a.$getSiteId = function () {
        return a.lk
    };
    a.$skuretarget = function (i, j) {
    };
    a.$getSkuPath = function () {
    };
    a.zU = function () {
        var k;
        var j = $mvt.hI;
        if (!f) {
            a.zh();
            a.lS = a.lf();
            a.li = new $mvt.rw(j, d)
        }
        if (g()) {
            a.lK()
        }
        if (!f) {
            if (g()) {
                a.lR = a.lj(a.referrer, j.domain);
                if (d.ri) {
                    a.lc = new $mvt.Hs(d.rc);
                    a.lc.XT()
                }
                k = new $mvt.xO(a.lS, j, a.lR, a.xs, d);
                k.lx(a.li, a.xK);
                c.Xj = k;
                c.Xf = k.xy
            }
            try {
                a.zo()
            } catch (i) {
            }
            f = true
        }
    };
    a.zo = function () {
        var j = [249, 394], l = true;
        var o = a.lk.split("-")[1];
        for (var n = 0, k = j.length; n < k; n++) {
            if (j[n] == o) {
                l = false
            }
        }
        if (!l) {
            return j
        }
        var m = $mvt.hI.cookie;
        if (!$mvt.G(m, "_jzqckmp=")) {
            function i(p) {
                var q = document.createElement("iframe");
                q.style.width = "1px";
                q.style.border = 0;
                q.style.position = "absolute";
                q.style.left = "-100px";
                q.style.top = "-100px";
                q.style.height = "1px";
                q.src = p;
                q.id = "mediav_cookiemapping";
                document.body.insertBefore(q, document.body.childNodes[0])
            }

            if (document.location.protocol == "https:") {
            } else {
                i("http://ckmap.mediav.com/b?type=10&jzqs=" + a.lk)
            }
            a.zb()
        }
    };
    a.zb = function () {
        a.li.XN()
    };
    a.zB = function () {
        var l = [], n, k, j, m;
        a.zU();
        var i;
        if (a.zy) {
            i = a.zy && function () {
                a.zy && a.zy();
                a.zy = null
            };
            setTimeout(function () {
                a.zy && a.zy();
                a.zy = null
            }, 500)
        }
        if (a.lL) {
            for (n = 0; n < a.lL.Hb[$mvt.X]; n++) {
                k = a.lL.Hb[n];
                $mvt.hR(l, k.HS());
                for (j = 0; j < k.Hu[$mvt.X]; j++) {
                    $mvt.hR(l, k.Hu[j].HS())
                }
            }
            a.lL.Hb = [];
            for (m = 0; m < l[$mvt.X]; m++) {
                c.Xs(l[m], a.lk, $mvt.hI, a.lS, true, i)
            }
        }
    };
    a.$addLogCallback = function (i) {
        a.zy = i
    };
    a.zY = function (l, n, i, m, k, j) {
        a.lL = a.lL ? a.lL : new $mvt.HG;
        return a.lL.HZ(l, n, i, m, k, j)
    };
    a.$addItem = function (k, j, n, m, l) {
        var i;
        a.lL = a.lL ? a.lL : new $mvt.HG;
        i = a.lL.HK(k);
        if (!i) {
            i = a.zY(k, "", "", "")
        }
        i.Hf(j, n, m, l)
    };
    a.$logOrder = function (l, n, i, m, k, j) {
        a.zY(l, n, i, m, k, j);
        a.zB()
    };
    a.$addOrder = function (l, n, i, m, k, j) {
        a.zY(l, n, i, m, k, j);
        a.zB()
    };
    a.$logAction = function (o, l, m, n, k, j) {
        var i;
        if (a.zy) {
            i = a.zy && function () {
                a.zy && a.zy();
                a.zy = null
            };
            setTimeout(function () {
                a.zy && a.zy();
                a.zy = null
            }, 500)
        }
        a.zU();
        c.Xs("&jzqt=evnt&jzqe=" + $mvt.p(o) + ($mvt.U(l) ? "" : "&jzqev=" + $mvt.p(l)) + ($mvt.U(m) ? "" : "&jzqo1=" + $mvt.p(m)) + ($mvt.U(n) ? "" : "&jzqo2=" + $mvt.p(n)) + ($mvt.U(k) ? "" : "&jzqo3=" + $mvt.p(k)) + ($mvt.U(j) ? "" : "&jzqo4=" + $mvt.p(j)), a.lk, $mvt.hI, a.lS, true, i)
    };
    a.$logConversion = function ($p) {
        if (g()) {
            a.zU();
            a.lE($p);
            a.xK = false
        }
    };
    a.$setDebugGIFPath = function (i) {
        d.zi = i
    };
    a.$addEngine = function (j, i) {
        $mvt.hR(d.rk, new $mvt.z(j, i))
    };
    a.$setDomainName = function (i) {
        d.rm = i
    };
    a.$setAccount = function (j) {
        var i = j;
        try {
            i = i + "";
            if (!i.indexOf("m-") == 0) {
                i = "m-" + i + "-0";
                j = i
            }
        } catch (k) {
        }
        a.lk = j
    };
    a.$setSourceExpire = function (i) {
        $mvt.rT = i
    }
};
$mvt.zw = function () {
    var a = this;
    a.push = function () {
        for (var d = arguments, h = 0, e = 0; h < d.length; h++) {
            if (typeof d[h] === "function") {
                d[h]()
            } else {
                var c = "", b = d[h][0], f = b.lastIndexOf(".");
                if (f > 0) {
                    c = b.substring(0, f);
                    b = b.substring(f + 1)
                }
                c = $mvt.$getTrackerByName(c);
                if (c[b]) {
                    c[b].apply(c, d[h].slice(1))
                }
            }
        }
        return e
    }
};
$mvt.$createTracker = function (c, a) {
    var b = new $mvt.$site(c);
    a && ($mvt.x[a] = b);
    return b
};
$mvt.$getTracker = function (a) {
    a = a || "";
    return $mvt.$createTracker(a)
};
$mvt.$getTrackerByName = function (a) {
    var b;
    if (a) {
        b = $mvt.x[a] || $mvt.$createTracker("", a)
    } else {
        b = $mvt.zP || ($mvt.zP = $mvt.$getTracker())
    }
    return b
};
(function () {
    function d() {
        var k = window._mv_loader = {};
        k.zj = [];
        k.reg = function (m, l) {
            this.zj.push([m, l])
        };
        k.zE = 0;
        k.zK = 0;
        var i = new Date() - 0;
        k.random = [i + "1", i + "2", i + "3"];
        k.zQ = function (l) {
            var m = k.random[k[l]];
            if (l == "mv") {
                k.zE++
            } else {
                k.zK++
            }
            return m
        };
        k.hA = k.cmdList = [];
        k.runCmd = function () {
            for (var n = 0, m = this.zj.length; n < m; n++) {
                var l = this.zj[n];
                l[1].apply(l[0], arguments)
            }
        };
        k.support = function (p) {
            function m(q) {
                this.hX = q
            }

            m.prototype = {
                push: function () {
                    var q = arguments.length;
                    for (var r = 0; r < q; r++) {
                        var t = [];
                        Array.prototype.push.apply(t, arguments[r]);
                        var s = t.shift();
                        this.hX[s] && this.hX[s].apply(this.hX, t)
                    }
                }
            };
            var l = window._mv_loader, o = l.hz, n = new m(p);
            l.hM(n, n.push);
            n.push.apply(n, o);
            return
        };
        var h = window._mvq;
        if (window._mvq) {
            for (var j = 0, g = h.length; j < g; j++) {
                k.runCmd.call(k, h[j]);
                k.cmdList.push(h[j])
            }
        }
        window._mvq = h = {};
        h.push = function () {
            k.runCmd.apply(k, arguments);
            Array.prototype.push.apply(k.cmdList, arguments)
        };

        function f() {
            var l = document.createElement("script");
            l.type = "text/javascript";
            l.ho = true;
            l.src = "http://material.mediav.com/bjjs/mba.js";
            var m = document.getElementsByTagName("script")[0];
            m.parentNode.insertBefore(l, m)
        }

        f()
    }

    if (!window._mv_loader) {
        d()
    }
    var a = window._mv_loader, e = a.cmdList, c = new $mvt.zw;
    a.reg(c, c.push);
    c.push.apply(c, e);
    return;
    var e = window[$mvt.hO], b = new $mvt.zw;
    if (e) {
        if (e instanceof Array) {
            window[$mvt.hO] = b;
            b.push.apply(b, e)
        }
    } else {
        window[$mvt.hO] = b
    }
})();