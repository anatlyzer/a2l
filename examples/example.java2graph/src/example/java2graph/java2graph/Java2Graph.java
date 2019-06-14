package example.java2graph.java2graph;

import blackboard.IdentifiableElement;
import blackboard.IArea;
import blackboard.BlackboardException;
import transfo.ITransformation;
import transfo.IMaster;
import transfo.TraceFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javamm.IPackage;
import javamm.IClassDeclaration;
import javamm.IModifier;
import javamm.InheritanceKind;
import graphmm.Node;
import javamm.IBodyDeclaration;
import javamm.IFieldDeclaration;
import graphmm.Edge;
import javamm.IAbstractTypeDeclaration;
import javamm.ITypeAccess;
import javamm.IType;

public class Java2Graph implements ITransformation {
	IArea srcArea, trgArea, cachingArea;

	public Java2Graph(IArea srcArea, IArea trgArea, IArea cachingArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
		this.cachingArea = cachingArea;
	}

	protected List<String> toList(String[] strings) {
		return java.util.Arrays.asList(strings);
	}

	protected IdentifiableElement read(IArea area, String id) throws BlackboardException {
		return id == null ? null : area.read(id);
	}

	protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException {
		return javaslang.collection.List.ofAll(srcArea.read(srcArea.size() + 1)).filter(e -> klass.isInstance(e))
				.map(e -> klass.cast(e));
	}

	public boolean check_toNode(IdentifiableElement inn) throws BlackboardException {
		IClassDeclaration tmp38;
		boolean tmp39;
		IPackage get40;
		java.lang.String id41;
		boolean op42;
		IPackage get43;
		java.lang.String id44;
		IPackage call45;
		java.lang.String get46;
		java.lang.String tmp47;
		int op48;
		int tmp49;
		boolean tmp50;
		boolean r51;
		if (inn instanceof IClassDeclaration) {
			tmp38 = (IClassDeclaration) inn;

			/*
			 * 34:4-38:8: if ( inn.package.oclIsUndefined() ) then false else
			 * inn.package.rootPackage().name.indexOf('java') < 0 endif
			 */
			/* 34:7-34:35: inn.package.oclIsUndefined() */
			/* 34:7-34:18: inn.package */
			id41 = tmp38.getPackage();

			get40 = (IPackage) read(srcArea, id41);

			op42 = get40 == null;

			r51 = false;

			if (op42) {
				tmp39 = false;

				r51 = tmp39;
			} else { /*
						 * 37:4-37:50:
						 * inn.package.rootPackage().name.indexOf('java')
						 */
				/* 37:4-37:34: inn.package.rootPackage().name */
				/* 37:4-37:29: inn.package.rootPackage() */
				/* 37:4-37:15: inn.package */
				id44 = tmp38.getPackage();

				get43 = (IPackage) read(srcArea, id44);

				if (get43 instanceof IPackage) {
					call45 = helper_IPackage_rootPackage((IPackage) get43);
				} else {
					throw new IllegalStateException();
				}
				get46 = call45.getName();

				tmp47 = "java";

				op48 = get46.indexOf(tmp47);

				tmp49 = 0;

				tmp50 = op48 < tmp49;

				r51 = tmp50;
			}
			return r51 == true;
		}
		return false;
	}

	public boolean check_toEdge(IdentifiableElement fd) throws BlackboardException {
		IFieldDeclaration tmp59;
		ITypeAccess get60;
		java.lang.String id61;
		IType get62;
		java.lang.String id63;
		IPackage call64;
		IPackage call65;
		java.lang.String get66;
		java.lang.String tmp67;
		int op68;
		int tmp69;
		boolean tmp70;
		IAbstractTypeDeclaration get71;
		java.lang.String id72;
		boolean op73;
		IClassDeclaration get74;
		java.lang.String id75;
		IPackage get76;
		java.lang.String id77;
		IPackage call78;
		java.lang.String get79;
		java.lang.String tmp80;
		int op81;
		int tmp82;
		boolean tmp83;
		IClassDeclaration get84;
		java.lang.String id85;
		IPackage get86;
		java.lang.String id87;
		boolean op88;
		boolean tmp89;
		boolean tmp90;
		boolean r91;
		boolean tmp92;
		IAbstractTypeDeclaration get93;
		java.lang.String id94;
		boolean op95;
		boolean tmp96;
		boolean tmp97;
		boolean r98;
		boolean tmp99;
		ITypeAccess get100;
		java.lang.String id101;
		IType get102;
		java.lang.String id103;
		IPackage call104;
		boolean op105;
		boolean tmp106;
		boolean tmp107;
		boolean r108;
		ITypeAccess get109;
		java.lang.String id110;
		IType get111;
		java.lang.String id112;
		boolean op113;
		ITypeAccess get114;
		java.lang.String id115;
		IType get116;
		java.lang.String id117;
		boolean op118;
		boolean tmp119;
		boolean tmp120;
		boolean r121;
		ITypeAccess get122;
		java.lang.String id123;
		boolean op124;
		boolean tmp125;
		boolean tmp126;
		boolean r127;
		boolean tmp128;
		boolean r129;
		if (fd instanceof IFieldDeclaration) {
			tmp59 = (IFieldDeclaration) fd;

			/*
			 * 52:4-79:8: if ( if ( not fd.type.oclIsUndefined() ) then if ( not
			 * fd.type.type.oclIsUndefined() ) then
			 * fd.type.type.oclIsTypeOf(MM!ClassDeclaration) else false endif
			 * else false endif ) then if ( not
			 * fd.type.type.package().oclIsUndefined() ) then
			 * fd.type.type.package().rootPackage().name.indexOf('java') < 0 and
			 * if ( not fd.abstractTypeDeclaration.oclIsUndefined() ) then
			 * fd.abstractTypeDeclaration.oclIsTypeOf(MM!ClassDeclaration) and
			 * if ( not fd.abstractTypeDeclaration.package.oclIsUndefined() )
			 * then
			 * fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('
			 * java') < 0 else false endif else false endif else false endif
			 * else false endif
			 */
			/*
			 * 52:8-60:9: if ( not fd.type.oclIsUndefined() ) then if ( not
			 * fd.type.type.oclIsUndefined() ) then
			 * fd.type.type.oclIsTypeOf(MM!ClassDeclaration) else false endif
			 * else false endif
			 */
			/* 52:15-52:39: fd.type.oclIsUndefined() */
			/* 52:15-52:22: fd.type */
			id123 = tmp59.getType();

			get122 = (ITypeAccess) read(srcArea, id123);

			op124 = get122 == null;

			tmp125 = !op124;

			r127 = false;

			if (tmp125) {
				/*
				 * 53:5-57:10: if ( not fd.type.type.oclIsUndefined() ) then
				 * fd.type.type.oclIsTypeOf(MM!ClassDeclaration) else false
				 * endif
				 */
				/* 53:12-53:41: fd.type.type.oclIsUndefined() */
				/* 53:12-53:24: fd.type.type */
				/* 53:12-53:19: fd.type */
				id115 = tmp59.getType();

				get114 = (ITypeAccess) read(srcArea, id115);

				id117 = get114.getType();

				get116 = (IType) read(srcArea, id117);

				op118 = get116 == null;

				tmp119 = !op118;

				r121 = false;

				if (tmp119) {
					/*
					 * 54:6-54:51: fd.type.type.oclIsTypeOf(MM!ClassDeclaration)
					 */
					/* 54:6-54:18: fd.type.type */
					/* 54:6-54:13: fd.type */
					id110 = tmp59.getType();

					get109 = (ITypeAccess) read(srcArea, id110);

					id112 = get109.getType();

					get111 = (IType) read(srcArea, id112);

					op113 = get111.getTypeId().equals("ClassDeclaration");

					r121 = op113;
				} else {
					tmp120 = false;

					r121 = tmp120;
				}
				r127 = r121;
			} else {
				tmp126 = false;

				r127 = tmp126;
			}
			r129 = false;

			if (r127) {
				/*
				 * 61:4-76:9: if ( not fd.type.type.package().oclIsUndefined() )
				 * then
				 * fd.type.type.package().rootPackage().name.indexOf('java') < 0
				 * and if ( not fd.abstractTypeDeclaration.oclIsUndefined() )
				 * then
				 * fd.abstractTypeDeclaration.oclIsTypeOf(MM!ClassDeclaration)
				 * and if ( not
				 * fd.abstractTypeDeclaration.package.oclIsUndefined() ) then
				 * fd.abstractTypeDeclaration.package.rootPackage().name.indexOf
				 * ('java') < 0 else false endif else false endif else false
				 * endif
				 */
				/* 61:11-61:50: fd.type.type.package().oclIsUndefined() */
				/* 61:11-61:33: fd.type.type.package() */
				/* 61:11-61:23: fd.type.type */
				/* 61:11-61:18: fd.type */
				id101 = tmp59.getType();

				get100 = (ITypeAccess) read(srcArea, id101);

				id103 = get100.getType();

				get102 = (IType) read(srcArea, id103);

				if (get102 instanceof IClassDeclaration) {
					call104 = helper_IClassDeclaration_package((IClassDeclaration) get102);
				} else {
					throw new IllegalStateException();
				}
				op105 = call104 == null;

				tmp106 = !op105;

				r108 = false;

				if (tmp106) {
					/*
					 * 62:5-62:62:
					 * fd.type.type.package().rootPackage().name.indexOf('java')
					 */
					/* 62:5-62:46: fd.type.type.package().rootPackage().name */
					/* 62:5-62:41: fd.type.type.package().rootPackage() */
					/* 62:5-62:27: fd.type.type.package() */
					/* 62:5-62:17: fd.type.type */
					/* 62:5-62:12: fd.type */
					id61 = tmp59.getType();

					get60 = (ITypeAccess) read(srcArea, id61);

					id63 = get60.getType();

					get62 = (IType) read(srcArea, id63);

					if (get62 instanceof IClassDeclaration) {
						call64 = helper_IClassDeclaration_package((IClassDeclaration) get62);
					} else {
						throw new IllegalStateException();
					}
					if (call64 instanceof IPackage) {
						call65 = helper_IPackage_rootPackage((IPackage) call64);
					} else {
						throw new IllegalStateException();
					}
					get66 = call65.getName();

					tmp67 = "java";

					op68 = get66.indexOf(tmp67);

					tmp69 = 0;

					tmp70 = op68 < tmp69;

					/*
					 * 62:71-73:10: if ( not
					 * fd.abstractTypeDeclaration.oclIsUndefined() ) then
					 * fd.abstractTypeDeclaration.oclIsTypeOf(MM!
					 * ClassDeclaration) and if ( not
					 * fd.abstractTypeDeclaration.package.oclIsUndefined() )
					 * then
					 * fd.abstractTypeDeclaration.package.rootPackage().name.
					 * indexOf('java') < 0 else false endif else false endif
					 */
					/*
					 * 63:7-63:50: fd.abstractTypeDeclaration.oclIsUndefined()
					 */
					/* 63:7-63:33: fd.abstractTypeDeclaration */
					id94 = tmp59.getAbstractTypeDeclaration();

					get93 = (IAbstractTypeDeclaration) read(srcArea, id94);

					op95 = get93 == null;

					tmp96 = !op95;

					r98 = false;

					if (tmp96) {
						/*
						 * 64:6-64:65:
						 * fd.abstractTypeDeclaration.oclIsTypeOf(MM!
						 * ClassDeclaration)
						 */
						/* 64:6-64:32: fd.abstractTypeDeclaration */
						id72 = tmp59.getAbstractTypeDeclaration();

						get71 = (IAbstractTypeDeclaration) read(srcArea, id72);

						op73 = get71.getTypeId().equals("ClassDeclaration");

						/*
						 * 64:70-70:11: if ( not
						 * fd.abstractTypeDeclaration.package.oclIsUndefined() )
						 * then
						 * fd.abstractTypeDeclaration.package.rootPackage().name
						 * .indexOf('java') < 0 else false endif
						 */
						/*
						 * 65:12-65:63:
						 * fd.abstractTypeDeclaration.package.oclIsUndefined()
						 */
						/* 65:12-65:46: fd.abstractTypeDeclaration.package */
						/* 65:12-65:38: fd.abstractTypeDeclaration */
						id85 = tmp59.getAbstractTypeDeclaration();

						get84 = (IClassDeclaration) read(srcArea, id85);

						id87 = get84.getPackage();

						get86 = (IPackage) read(srcArea, id87);

						op88 = get86 == null;

						tmp89 = !op88;

						r91 = false;

						if (tmp89) {
							/*
							 * 66:7-67:24:
							 * fd.abstractTypeDeclaration.package.rootPackage().
							 * name.indexOf('java')
							 */
							/*
							 * 66:7-66:60:
							 * fd.abstractTypeDeclaration.package.rootPackage().
							 * name
							 */
							/*
							 * 66:7-66:55:
							 * fd.abstractTypeDeclaration.package.rootPackage()
							 */
							/* 66:7-66:41: fd.abstractTypeDeclaration.package */
							/* 66:7-66:33: fd.abstractTypeDeclaration */
							id75 = tmp59.getAbstractTypeDeclaration();

							get74 = (IClassDeclaration) read(srcArea, id75);

							id77 = get74.getPackage();

							get76 = (IPackage) read(srcArea, id77);

							if (get76 instanceof IPackage) {
								call78 = helper_IPackage_rootPackage((IPackage) get76);
							} else {
								throw new IllegalStateException();
							}
							get79 = call78.getName();

							tmp80 = "java";

							op81 = get79.indexOf(tmp80);

							tmp82 = 0;

							tmp83 = op81 < tmp82;

							r91 = tmp83;
						} else {
							tmp90 = false;

							r91 = tmp90;
						}
						tmp92 = op73 && r91;

						r98 = tmp92;
					} else {
						tmp97 = false;

						r98 = tmp97;
					}
					tmp99 = tmp70 && r98;

					r108 = tmp99;
				} else {
					tmp107 = false;

					r108 = tmp107;
				}
				r129 = r108;
			} else {
				tmp128 = false;

				r129 = tmp128;
			}
			return r129 == true;
		}
		return false;
	}

	public IPackage helper_IPackage_rootPackage(IPackage self_) throws BlackboardException {
		IPackage get0;
		java.lang.String id1;
		boolean op2;
		IPackage get3;
		java.lang.String id4;
		IPackage call5;
		IPackage r6;/*
					 * 11:2-11:82: if ( self.package.oclIsUndefined() ) then
					 * self else self.package.rootPackage() endif
					 */
		/* 11:5-11:34: self.package.oclIsUndefined() */
		/* 11:5-11:17: self.package */
		id1 = self_.getPackage();

		get0 = (IPackage) read(srcArea, id1);

		op2 = get0 == null;

		r6 = null;

		if (op2) {
			r6 = self_;
		} else { /* 11:50-11:76: self.package.rootPackage() */
			/* 11:50-11:62: self.package */
			id4 = self_.getPackage();

			get3 = (IPackage) read(srcArea, id4);

			if (get3 instanceof IPackage) {
				call5 = helper_IPackage_rootPackage((IPackage) get3);
			} else {
				throw new IllegalStateException();
			}
			r6 = call5;
		}
		return r6;
	}

	public IPackage helper_IClassDeclaration_package(IClassDeclaration self_) throws BlackboardException {
		IPackage get7;
		java.lang.String id8;/* 14:2-14:14: self.package */
		id8 = self_.getPackage();

		get7 = (IPackage) read(srcArea, id8);

		return get7;
	}

	public java.lang.String helper_global_type(IClassDeclaration cd) throws BlackboardException {
		java.lang.String tmp9;
		IModifier get10;
		java.lang.String id11;
		InheritanceKind get12;
		InheritanceKind tmp13;
		boolean tmp14;
		java.lang.String tmp15;
		IModifier get16;
		java.lang.String id17;
		InheritanceKind get18;
		InheritanceKind tmp19;
		boolean tmp20;
		java.lang.String tmp21;
		java.lang.String r22;
		java.lang.String r23;
		IModifier get24;
		java.lang.String id25;
		boolean op26;
		boolean tmp27;
		java.lang.String tmp28;
		java.lang.String r29;/*
								 * 17:2-29:7: if ( not
								 * cd.modifier.oclIsUndefined() ) then if (
								 * cd.modifier.inheritance = #final ) then 'F'
								 * else if ( cd.modifier.inheritance = #abstract
								 * ) then 'A' else 'N' endif endif else 'N'
								 * endif
								 */
		/* 17:9-17:37: cd.modifier.oclIsUndefined() */
		/* 17:9-17:20: cd.modifier */
		id25 = cd.getModifier();

		get24 = (IModifier) read(srcArea, id25);

		op26 = get24 == null;

		tmp27 = !op26;

		r29 = "";

		if (tmp27) {
			/*
			 * 18:3-26:8: if ( cd.modifier.inheritance = #final ) then 'F' else
			 * if ( cd.modifier.inheritance = #abstract ) then 'A' else 'N'
			 * endif endif
			 */
			/* 18:6-18:29: cd.modifier.inheritance */
			/* 18:6-18:17: cd.modifier */
			id11 = cd.getModifier();

			get10 = (IModifier) read(srcArea, id11);

			get12 = get10.getInheritance();

			tmp13 = InheritanceKind.final_;

			tmp14 = get12 == tmp13;

			r23 = "";

			if (tmp14) {
				tmp9 = "F";

				r23 = tmp9;
			} else { /*
						 * 21:4-25:9: if ( cd.modifier.inheritance = #abstract )
						 * then 'A' else 'N' endif
						 */
				/* 21:7-21:30: cd.modifier.inheritance */
				/* 21:7-21:18: cd.modifier */
				id17 = cd.getModifier();

				get16 = (IModifier) read(srcArea, id17);

				get18 = get16.getInheritance();

				tmp19 = InheritanceKind.abstract_;

				tmp20 = get18 == tmp19;

				r22 = "";

				if (tmp20) {
					tmp15 = "A";

					r22 = tmp15;
				} else {
					tmp21 = "N";

					r22 = tmp21;
				}
				r23 = r22;
			}
			r29 = r23;
		} else {
			tmp28 = "N";

			r29 = tmp28;
		}
		return r29;
	}

	public boolean isTargetElement(IdentifiableElement obj) {
		return "MM1".equals(obj.getTrgId());
	}

	public void create_toNode(IClassDeclaration inn) throws BlackboardException {
		Node out30;
		java.lang.String get31;
		java.lang.String call32;
		javaslang.collection.List<IBodyDeclaration> get33;
		java.lang.String[] id34;
		boolean op35;
		javaslang.collection.List<IFieldDeclaration> r36;
		int op37;
		out30 = new Node();

		out30.setTrgId("MM1");

		out30.setId(TraceFunction.create(inn.getId(), 0, "toNode"));

		/* 42:12-42:20: inn.name */
		get31 = inn.getName();

		/* 43:12-43:32: thisModule.type(inn) */
		call32 = helper_global_type(inn);

		/*
		 * 44:12-45:49: inn.bodyDeclarations->select(bd |
		 * bd.oclIsTypeOf(MM!FieldDeclaration))->size()
		 */
		/*
		 * 44:12-45:39: inn.bodyDeclarations->select(bd |
		 * bd.oclIsTypeOf(MM!FieldDeclaration))
		 */
		/* 44:12-44:32: inn.bodyDeclarations */
		id34 = inn.getBodyDeclarations();

		get33 = javaslang.collection.List.ofAll(
				new uk.ac.ebi.utils.collections.TypeCastCollection<IBodyDeclaration>(srcArea.readAll(toList(id34))));

		r36 = javaslang.collection.List.empty();

		for (IBodyDeclaration bd : get33) {
			/* 44:48-45:38: bd.oclIsTypeOf(MM!FieldDeclaration) */
			op35 = bd.getTypeId().equals("FieldDeclaration");

			if (op35 == true) {
				r36 = r36.prepend((IFieldDeclaration) bd);
			}
		}
		op37 = r36.size();

		out30.setName(get31);

		out30.setType(call32);

		out30.setSize(op37);

		trgArea.write(out30);
	}

	public void create_toEdge(IFieldDeclaration fd) throws BlackboardException {
		Edge e52;
		IAbstractTypeDeclaration get53;
		java.lang.String id54;
		ITypeAccess get55;
		java.lang.String id56;
		IType get57;
		java.lang.String id58;
		e52 = new Edge();

		e52.setTrgId("MM1");

		e52.setId(TraceFunction.create(fd.getId(), 0, "toEdge"));

		/* 83:14-83:40: fd.abstractTypeDeclaration */
		id54 = fd.getAbstractTypeDeclaration();

		get53 = (IAbstractTypeDeclaration) read(srcArea, id54);

		/* 84:14-84:26: fd.type.type */
		/* 84:14-84:21: fd.type */
		id56 = fd.getType();

		get55 = (ITypeAccess) read(srcArea, id56);

		id58 = get55.getType();

		get57 = (IType) read(srcArea, id58);

		boolean matched0 = false;
		if (check_toNode(get53)) {
			e52.setSource(TraceFunction.resolve(get53.getId(), 0, "toNode"));
		}

		boolean matched1 = false;
		if (check_toNode(get57)) {
			e52.setTarget(TraceFunction.resolve(get57.getId(), 0, "toNode"));
		}

		trgArea.write(e52);
	}

	public void transform(Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (IdentifiableElement e : objs) {
			boolean matched2 = false;
			System.out.println(check_toNode(e));
			System.out.println(check_toEdge(e));
			
			if (check_toNode(e)) {
				create_toNode((IClassDeclaration) e);
			} else if (check_toEdge(e)) {
				create_toEdge((IFieldDeclaration) e);
			}
		}
	}
}