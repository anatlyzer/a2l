<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="CollectFlatten"/>
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
		<constant value="__exec__"/>
		<constant value="A2B"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyA2B(NTransientLink;):V"/>
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
		<constant value="24:3-26:4"/>
		<constant value="__applyA2B"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.allInstances():J"/>
		<constant value="4"/>
		<constant value="J.&lt;&gt;(J):J"/>
		<constant value="B.not():B"/>
		<constant value="31"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="B"/>
		<constant value="5"/>
		<constant value="J.=(J):J"/>
		<constant value="52"/>
		<constant value="J.flatten():J"/>
		<constant value="J.first():J"/>
		<constant value="25:12-25:18"/>
		<constant value="25:12-25:33"/>
		<constant value="25:46-25:47"/>
		<constant value="25:46-25:52"/>
		<constant value="25:56-25:59"/>
		<constant value="25:46-25:59"/>
		<constant value="25:12-25:60"/>
		<constant value="25:74-25:80"/>
		<constant value="25:74-25:95"/>
		<constant value="25:108-25:109"/>
		<constant value="25:108-25:114"/>
		<constant value="25:117-25:118"/>
		<constant value="25:117-25:123"/>
		<constant value="25:108-25:123"/>
		<constant value="25:74-25:124"/>
		<constant value="25:12-25:125"/>
		<constant value="25:12-25:136"/>
		<constant value="25:12-25:145"/>
		<constant value="25:12-25:150"/>
		<constant value="25:4-25:150"/>
		<constant value="link"/>
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
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="47"/>
			<findme/>
			<push arg="48"/>
			<call arg="49"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="51"/>
			<dup/>
			<push arg="52"/>
			<load arg="19"/>
			<pcall arg="53"/>
			<dup/>
			<push arg="54"/>
			<push arg="46"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<pusht/>
			<pcall arg="57"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="58" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="59">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="60"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="52"/>
			<call arg="61"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="62"/>
			<store arg="63"/>
			<load arg="63"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="6"/>
			<push arg="47"/>
			<findme/>
			<call arg="64"/>
			<iterate/>
			<store arg="65"/>
			<load arg="65"/>
			<get arg="38"/>
			<push arg="54"/>
			<call arg="66"/>
			<call arg="67"/>
			<if arg="68"/>
			<load arg="65"/>
			<call arg="69"/>
			<enditerate/>
			<iterate/>
			<store arg="65"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="70"/>
			<push arg="47"/>
			<findme/>
			<call arg="64"/>
			<iterate/>
			<store arg="71"/>
			<load arg="71"/>
			<get arg="38"/>
			<load arg="65"/>
			<get arg="38"/>
			<call arg="72"/>
			<call arg="67"/>
			<if arg="73"/>
			<load arg="71"/>
			<call arg="69"/>
			<enditerate/>
			<call arg="69"/>
			<enditerate/>
			<call arg="74"/>
			<call arg="75"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="76" begin="17" end="19"/>
			<lne id="77" begin="17" end="20"/>
			<lne id="78" begin="23" end="23"/>
			<lne id="79" begin="23" end="24"/>
			<lne id="80" begin="25" end="25"/>
			<lne id="81" begin="23" end="26"/>
			<lne id="82" begin="14" end="31"/>
			<lne id="83" begin="37" end="39"/>
			<lne id="84" begin="37" end="40"/>
			<lne id="85" begin="43" end="43"/>
			<lne id="86" begin="43" end="44"/>
			<lne id="87" begin="45" end="45"/>
			<lne id="88" begin="45" end="46"/>
			<lne id="89" begin="43" end="47"/>
			<lne id="90" begin="34" end="52"/>
			<lne id="91" begin="11" end="54"/>
			<lne id="92" begin="11" end="55"/>
			<lne id="93" begin="11" end="56"/>
			<lne id="94" begin="11" end="57"/>
			<lne id="95" begin="9" end="59"/>
			<lne id="58" begin="8" end="60"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="52" begin="22" end="30"/>
			<lve slot="5" name="54" begin="42" end="51"/>
			<lve slot="4" name="52" begin="33" end="53"/>
			<lve slot="3" name="54" begin="7" end="60"/>
			<lve slot="2" name="52" begin="3" end="60"/>
			<lve slot="0" name="17" begin="0" end="60"/>
			<lve slot="1" name="96" begin="0" end="60"/>
		</localvariabletable>
	</operation>
</asm>
