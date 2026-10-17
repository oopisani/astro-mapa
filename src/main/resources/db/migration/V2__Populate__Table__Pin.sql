INSERT INTO `pins`
    (`id`, `latitude`, `longitude`, `name`, `location_type`, `is_safe`,
     `easy_access`, `star_visibility`, `uap_sighting`,
     `uap_sighting_datetime`, `significant_moment`, `created_at`)

     VALUES
    (1, -27.5954, -48.5480, 'Morro da Cruz', 'Morro', true,
     true, 'High', false,
     NULL, 'Foi aqui que vi a Via Láctea pela primeira vez.', '2026-10-01 20:30:00'),

    (2, -27.5700, -48.4400, 'Praia da Joaquina', 'Praia', true,
     true, 'High', false,
     NULL, NULL, '2026-10-02 21:15:00'),

    (3, -27.6200, -48.4900, 'Lagoa da Conceição', 'Mirante', true,
     true, 'Medium', true,
     '2026-09-15 23:40:00', 'Vi uma luz estranha cruzando o céu naquela noite.', '2026-10-03 19:45:00'),

    (4, -27.7000, -48.5000, 'Praia do Campeche', 'Praia', true,
     true, 'High', false,
     NULL, NULL, '2026-10-04 22:00:00'),

    (5, -27.7500, -48.5200, 'Praia do Matadeiro', 'Praia', true,
     false, 'High', false,
     NULL, 'Um dos céus mais bonitos que já vi perto da cidade.', '2026-10-05 21:30:00'),

    (6, -27.5800, -48.5100, 'Parque Municipal', 'Planalto', true,
     true, 'Low', false,
     NULL, NULL, '2026-10-06 20:10:00');