class Aircraft {
    protected int maxAmmo;
    protected int baseDamage;
    protected int ammo;

    public Aircraft(int maxAmmo, int baseDamage) {
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
        this.ammo = 0;
    }

    public int fight() {
        int damage = baseDamage * ammo;
        ammo = 0;
        return damage;
    }

    public int refillAmmo(int amount) {
        int remainingAmmo = Math.min(maxAmmo - ammo, amount);
        ammo += remainingAmmo;
        return amount - remainingAmmo;
    }

    public String getType() {
        return getClass().getSimpleName();
    }

    public String getStatus() {
        return "Type " + getType() + ", Ammo: " + ammo + ", Base Damage: " + baseDamage + ", All Damage: " + (ammo * baseDamage);
    }

    public boolean isPriority() {
        return false;
    }
}

class F16 extends Aircraft {
    public F16() {
        super(8, 30);
    }
}

class F35 extends Aircraft {
    public F35() {
        super(12, 50);
    }

    @Override
    public boolean isPriority() {
        return true;
    }



    public static void main(String[] args) {
        F16 f16 = new F16();
        F35 f35 = new F35();

        System.out.println(f16.getType());
        System.out.println(f35.getType());

        f16.refillAmmo(5);
        f35.refillAmmo(10);

        System.out.println(f16.getStatus());
        System.out.println(f35.getStatus());
    }
}
