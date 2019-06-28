<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="ResolveTemp"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchA2B():V"/>
		<constant value="A.__matchB2W():V"/>
		<constant value="A.__matchC2W():V"/>
		<constant value="__exec__"/>
		<constant value="A2B"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyA2B(NTransientLink;):V"/>
		<constant value="B2W"/>
		<constant value="A.__applyB2W(NTransientLink;):V"/>
		<constant value="C2W"/>
		<constant value="A.__applyC2W(NTransientLink;):V"/>
		<constant value="__matchA2B"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="a"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="b"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="21:3-24:4"/>
		<constant value="__applyA2B"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="elements"/>
		<constant value="4"/>
		<constant value="out2"/>
		<constant value="J.resolveTemp(JJ):J"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="23:16-23:17"/>
		<constant value="23:16-23:26"/>
		<constant value="23:40-23:50"/>
		<constant value="23:63-23:64"/>
		<constant value="23:66-23:72"/>
		<constant value="23:40-23:73"/>
		<constant value="23:16-23:74"/>
		<constant value="23:4-23:74"/>
		<constant value="link"/>
		<constant value="__matchB2W"/>
		<constant value="B"/>
		<constant value="out"/>
		<constant value="W"/>
		<constant value="Z"/>
		<constant value="29:9-31:3"/>
		<constant value="31:5-33:3"/>
		<constant value="__applyB2W"/>
		<constant value="30:11-30:12"/>
		<constant value="30:11-30:17"/>
		<constant value="30:3-30:17"/>
		<constant value="32:11-32:12"/>
		<constant value="32:11-32:17"/>
		<constant value="32:3-32:17"/>
		<constant value="__matchC2W"/>
		<constant value="C"/>
		<constant value="39:9-41:3"/>
		<constant value="41:5-43:3"/>
		<constant value="__applyC2W"/>
		<constant value="40:11-40:12"/>
		<constant value="40:11-40:17"/>
		<constant value="40:3-40:17"/>
		<constant value="42:11-42:12"/>
		<constant value="42:11-42:17"/>
		<constant value="42:3-42:17"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
			<getasm/>
			<pcall arg="41"/>
			<getasm/>
			<pcall arg="42"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="5"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="46"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="47"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="48"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="50"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="0" name="17" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="52"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="44"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="52"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="64" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="65">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="29"/>
			<get arg="70"/>
			<iterate/>
			<store arg="71"/>
			<getasm/>
			<load arg="71"/>
			<push arg="72"/>
			<call arg="73"/>
			<call arg="74"/>
			<enditerate/>
			<call arg="30"/>
			<set arg="70"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="75" begin="14" end="14"/>
			<lne id="76" begin="14" end="15"/>
			<lne id="77" begin="18" end="18"/>
			<lne id="78" begin="19" end="19"/>
			<lne id="79" begin="20" end="20"/>
			<lne id="80" begin="18" end="21"/>
			<lne id="81" begin="11" end="23"/>
			<lne id="82" begin="9" end="25"/>
			<lne id="64" begin="8" end="26"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="33" begin="17" end="22"/>
			<lve slot="3" name="60" begin="7" end="26"/>
			<lve slot="2" name="58" begin="3" end="26"/>
			<lve slot="0" name="17" begin="0" end="26"/>
			<lve slot="1" name="83" begin="0" end="26"/>
		</localvariabletable>
	</operation>
	<operation name="84">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="85"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="47"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="86"/>
			<push arg="87"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<dup/>
			<push arg="72"/>
			<push arg="88"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="89" begin="19" end="24"/>
			<lne id="90" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="91">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="86"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="19"/>
			<push arg="72"/>
			<call arg="68"/>
			<store arg="71"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="71"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="92" begin="15" end="15"/>
			<lne id="93" begin="15" end="16"/>
			<lne id="94" begin="13" end="18"/>
			<lne id="89" begin="12" end="19"/>
			<lne id="95" begin="23" end="23"/>
			<lne id="96" begin="23" end="24"/>
			<lne id="97" begin="21" end="26"/>
			<lne id="90" begin="20" end="27"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="86" begin="7" end="27"/>
			<lve slot="4" name="72" begin="11" end="27"/>
			<lve slot="2" name="58" begin="3" end="27"/>
			<lve slot="0" name="17" begin="0" end="27"/>
			<lve slot="1" name="83" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="98">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="99"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="49"/>
			<pcall arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="86"/>
			<push arg="87"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<dup/>
			<push arg="72"/>
			<push arg="88"/>
			<push arg="61"/>
			<new/>
			<pcall arg="62"/>
			<pusht/>
			<pcall arg="63"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="100" begin="19" end="24"/>
			<lne id="101" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="102">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="86"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="19"/>
			<push arg="72"/>
			<call arg="68"/>
			<store arg="71"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="71"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="103" begin="15" end="15"/>
			<lne id="104" begin="15" end="16"/>
			<lne id="105" begin="13" end="18"/>
			<lne id="100" begin="12" end="19"/>
			<lne id="106" begin="23" end="23"/>
			<lne id="107" begin="23" end="24"/>
			<lne id="108" begin="21" end="26"/>
			<lne id="101" begin="20" end="27"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="86" begin="7" end="27"/>
			<lve slot="4" name="72" begin="11" end="27"/>
			<lve slot="2" name="58" begin="3" end="27"/>
			<lve slot="0" name="17" begin="0" end="27"/>
			<lve slot="1" name="83" begin="0" end="27"/>
		</localvariabletable>
	</operation>
</asm>
